import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point
    {
        int x;
        int y;
        int dis;
        boolean distroy;

        public Point(int x, int y, int dis, boolean distroy) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.distroy = distroy;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;

    static int[][] deltas={{-1,0},{0,1},{1,0},{0,-1}};
    static int min = Integer.MAX_VALUE;
    static Queue<Point> que = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        map[0][0] = 1;
        que.add(new Point(0,0,1,false));

        BFS();
        System.out.println(min == Integer.MAX_VALUE?"-1":min);
    }
    public static void BFS()
    {
        while(!que.isEmpty())
        {
            Point temp = que.poll();
            if(temp.x == N-1 && temp.y == M-1)
            {
                min = temp.dis;
                return;
            }
            for(int dir=0; dir<4; dir++)
            {
                int nx = temp.x + deltas[dir][0];
                int ny = temp.y + deltas[dir][1];
                if(nx < 0 || N <= nx || ny < 0 || M <= ny)
                    continue;

                if(map[nx][ny] == 0 )
                {
                    //지금까지 벽을 부순 적이 없으면
                    if(!temp.distroy && !visited[nx][ny][0])
                    {
                        que.add(new Point(nx,ny,temp.dis+1, false));
                        visited[nx][ny][0] = true;
                    }
                    //벽을 한번 부순적이 있으면
                    else if(temp.distroy && !visited[nx][ny][1])
                    {
                        que.add(new Point(nx,ny, temp.dis+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else
                {
                    if(!temp.distroy)
                    {
                        que.add(new Point(nx,ny,temp.dis+1,true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
    }
}
