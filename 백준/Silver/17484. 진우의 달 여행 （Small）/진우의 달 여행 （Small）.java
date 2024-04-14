import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class ship{
        int x,y;
        int d;
        int score;

        public ship(int x, int y, int d, int score)
        {
            this.x = x;
            this.y = y;
            this.d = d;
            this.score = score;
        }
    }

    static int min = Integer.MAX_VALUE;
    static int[][] deltas = {{1,-1},{1,0},{1,1}};
    static int[][] map;
    static Queue<ship> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==1)
                {
                    que.add(new ship(i,j,-1,map[i][j]));
                }
            }
        }

        while(!que.isEmpty())
        {
            ship temp = que.poll();
            for(int dir=0; dir<3; dir++)
            {
                if(temp.d == dir)
                    continue;
                int nx = temp.x;
                int ny = temp.y;
                nx += deltas[dir][0];
                ny += deltas[dir][1];
                if(ny < 0 || M <= ny)
                    continue;
                if(nx == N+1)
                {
                    min = Math.min(min,(temp.score+map[nx][ny]));

                    continue;
                }
                que.add(new ship(nx,ny,dir,temp.score+map[nx][ny]));
            }
        }
        System.out.println(min);
    }
}
