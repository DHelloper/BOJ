import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        dfs(0,K,0);
        visited[K] = true;
        System.out.println(result);
    }

    public static void dfs(int cnt, int start, int sum)
    {
        if(cnt == N)
        {
            result = Math.min(result,sum);
            return;
        }
        for(int i=0; i<N; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                dfs(cnt+1,i,sum+map[start][i]);
                visited[i] = false;
            }
        }
    }
}
