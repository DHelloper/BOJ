
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * N, M : 배열의 크기 N 과 M를 저장할 변수 선언
     * resultMax : 최댓값 저장 할 변수
     * visited : DFS를 돌릴 때 방문체크를 하기 위함
     * deltas : 방향 탐색을 위한 deltas 2차원 변수
     * map : 맵의 값을 저장할 변수
     */
    static int N;
    static int M;
    static int resultMax = Integer.MIN_VALUE;
    static boolean visited[][];
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
//                System.out.println("i : "+i);
//                System.out.println("j : "+j);
                visited[i][j] = true;
                dfs(0,map[i][j],i,j);
                visited[i][j] = false;
//                System.out.println(resultMax);
                int exceptCase = map[i][j];
                for(int dir=0; dir<4; dir++)
                {
                    int nr = i+deltas[dir][0];
                    int nc = j+deltas[dir][1];
                    if(nr < 0 || N <= nr || nc < 0 || M <= nc)
                        continue;
                    exceptCase += map[nr][nc];
                }
//                if(i==3 && j==2)
//                {
//                    System.out.println(exceptCase);
//                }
                for(int dir2 = 0; dir2<4; dir2++)
                {
                    int nr = i+deltas[dir2][0];
                    int nc = j+deltas[dir2][1];
                    if(nr < 0 || N <= nr || nc < 0 || M <= nc)
                    {
                        resultMax = Math.max(resultMax, exceptCase);
                        continue;
                    }
                    int exceptCase2 = exceptCase - map[nr][nc];
                    resultMax = Math.max(resultMax, exceptCase2);
                }
            }
        }
        System.out.println(resultMax);
    }


    /**
     * DFS를 돌릴것
     * cnt가 5가 되면 바로 깨져야 함.
     * 4칸을 진행하는 동안 배열 값 탐색하고 저장해야 함.
     * 방향 전환 가능해야 함.
     * 현재 위치의 값을 sum에 담고,
     * 다음 방향으로 진행.
     */
    public static void dfs(int cnt, int sum, int r, int c)
    {
//        System.out.println("SUM : "+sum + " CNT : "+cnt);
        if(cnt==3)
        {
            resultMax = Math.max(resultMax,sum);
            return;
        };

        for(int dir=0; dir<4; dir++)
        {
            int nr = r + deltas[dir][0];
            int nc = c + deltas[dir][1];
            if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc])
                continue;
            visited[nr][nc] = true;
            dfs(cnt+1,sum+map[nr][nc], nr, nc);
            visited[nr][nc] = false;
        }
    }
}
