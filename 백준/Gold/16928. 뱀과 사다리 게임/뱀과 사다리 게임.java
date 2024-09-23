import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] count;
    static int[] move;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 주사위를 조작해 내가 원하는 수가 나오게 만들 수 있다면 최소 몇 번만에 도착점에 도착할 수 있을까?
        // 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나 씩 적혀져 있다.
        // 게임판의 크기는 10 x 10 총 100칸
        // 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀있음
        // 주사위를 굴려 나온 수 만큼 이동해야 함
        // 도착한 칸이 사다리라면 사다리를 타고 위로 올라감.
        // 뱀이 있는 칸에 도착하면 뱀을 따라 내려감
        // 100번째 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값 구하기

        // 사다리의 수 N 뱀의 수 M
        // N개의 줄에는 사다리의 정보를 의미하는 x,y가 주어진다.
        // M개의 줄에는 뱀의 정보를 의미하는 u,v 가 주어진다.
        visited = new boolean[101];
        count = new int[101];
        move = new int[101];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }
        bfs();

    }

    public static void bfs() {
        que = new LinkedList<>();
        que.add(1);
        count[1] = 0;
        visited[1] = true;

        while(!que.isEmpty()) {
            int temp = que.poll();
            if(temp==100) {
                System.out.println(count[temp]);
                return;
            }

            for(int i=1; i<7; i++) {
                int x = temp+i;
                if(100<x || visited[x]) continue;
                visited[x] = true;

                if(move[x] != 0) { // 사다리 또는 뱀의 위치일 때
                    if(!visited[move[x]]) {
                        que.add(move[x]);
                        visited[move[x]] = true;
                        count[move[x]] = count[temp]+1;
                    }
                } else {
                    que.add(x);
                    count[x] = count[temp]+1;
                }
            }
        }
    }
}
