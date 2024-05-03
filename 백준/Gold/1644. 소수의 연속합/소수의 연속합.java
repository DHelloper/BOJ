import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new ArrayList<>();
        visited[0] = visited[1] = false; // 0과 1은 소수가 아니니깐 false
        int cnt=0;
        isPrime();
        for(int i=2; i<N+1; i++)
        {
            if(!visited[i])
                list.add(i);
        }
        for(int i=0; i<list.size(); i++)
        {
            int sum = list.get(i);
            if(list.get(i)==N){
                cnt++;
                break;
            }
            for(int j=i+1; j<list.size(); j++)
            {
                sum+=list.get(j);
                if(sum==N) {
                    cnt++;
                    break;
                }
                else if(sum>N)
                    break;
            }
        }
        System.out.println(cnt);
    }

    public static void isPrime()
    {
        for(int i = 2; i <= Math.sqrt(N); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(!visited[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<=N; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    visited[j] = true;
                }
            }
        }
    }

}
