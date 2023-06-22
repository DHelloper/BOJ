import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class tomato
    {
        public tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;

        }

        int x;
        int y;
        int z;
    }
    static int M;
    static int N;
    static int H;

    static int[][][] map;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<tomato> que = new ArrayDeque<>();
    // 1 : 익은 토마토
    // 0 : 익지 않은 토마토
    // -1 : 토마토 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        for(int i=0; i<H; i++)
        {
            for(int j=0; j<N; j++)
            {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++)
                {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1)
                    {
                        que.add(new tomato(i,j,k));
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS()
    {
        while(!que.isEmpty())
        {
            tomato temp = que.poll();

            int x = temp.x;
            int y = temp.y;
            int z = temp.z;

            for(int dir=0; dir<6; dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                int nz = z+dz[dir];

                if(nx < 0 || N <= nx || ny < 0 || M <= ny || nz < 0 || H <= nz)
                    continue;
                if(map[nz][nx][ny] == 0)
                {
                    que.add(new tomato(nz, nx, ny));
                    map[nz][nx][ny] = map[z][x][y] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i=0; i<H; i++)
        {
            for(int j=0; j<N; j++)
            {

                for(int k=0; k<M; k++)
                {
                    if(map[i][j][k] == 0)
                    {
                        return -1;
                    }
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return result-1;
    }
}
