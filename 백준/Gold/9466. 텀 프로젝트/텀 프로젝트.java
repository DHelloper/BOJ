import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] check;
    static int answer;
    public static void main(String[] args) throws IOException {
        // 모든 학생들이 한 팀인 경우 있음
        // 프로젝트를 함께 하고 싶은 학생 선택(단, 한명만 선택 가능)
        // 자기 자신을 선택 가능
        // DFS로 풀기.
        // 각 학생을 선택해서 이 학생이 누굴 가르키는지 확인하고, 그 학생을 또 타고 들어가봄. 그렇게 기존 자기 자신까지 돌아온다면. 그 넘버를 한팀으로 처리
        // visited로 관리 ?
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N+1];
            answer = 0;
            check = new boolean[N+1];
            check[0] = true;
            visited = new boolean[N+1];
            visited[0]= true;
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++)
            {
                if(!check[i]) {
                    DFS(i);
                }
            }
            System.out.println(N-answer);
        }
    }
    public static void DFS(int now)
    {
        if(visited[now])
        {
            check[now] = true;
            answer++;
        }
        else if(!visited[now]){
            visited[now] = true;
        }
        int next = arr[now];
        if(!check[next]) DFS(next);
        visited[now] = false;
        check[now] = true;

    }
}
