import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class point{
        int x,y;
        public point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static int[][] map;
    static int[] goal;
    static boolean[][] visited;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N][M];
        visited = new boolean[N][M];
        map = new int[N][M];
        goal = new int[2];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2)
                {
                    goal[0] = i;
                    goal[1] = j;
                    visited[i][j]=true;
                }
            }
        }

        BFS(goal[0],goal[1]);

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(!visited[i][j]&&map[i][j]==1)
                    sb.append(-1 + " ");
                else
                    sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void BFS(int x, int y) {
        Queue<point> que = new ArrayDeque<>();
        visited[x][y] = true;
        que.add(new point(x,y));
        while(!que.isEmpty())
        {
            point temp = que.poll();
            for(int d=0; d<4; d++)
            {
                int nx = temp.x+deltas[d][0];
                int ny = temp.y+deltas[d][1];
                if(nx<0||N<=nx || ny<0||M<=ny || map[nx][ny]==0 || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                result[nx][ny]=result[temp.x][temp.y]+1;
                que.add(new point(nx,ny));
            }
        }
    }
}
