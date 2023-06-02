import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node
    {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

    }
    static int N;
    static int M;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map;
    static int result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true)
        {
            int iceCnt = IceCount();
            if(iceCnt >= 2)
            {
                break;
            }
            else if(iceCnt == 0)
            {
                result = 0;
                break;
            }
            BFS();
            result++;
        }

        System.out.println(result);
    }

    public static int IceCount()
    {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(!visited[i][j] && map[i][j] > 0)
                {
                    DFS(i,j,visited);
                    cnt++;
                }

            }
        }
        return cnt;
    }

    public static void DFS(int x, int y, boolean[][] visited)
    {
        visited[x][y] = true;
        for(int dir=0; dir<4; dir++)
        {
            int nx = x+deltas[dir][0];
            int ny = y+deltas[dir][1];
            if(nx < 0 || N <= nx || ny < 0 || M <= ny || visited[nx][ny])
                continue;
            if(map[nx][ny] > 0)
            {
                DFS(nx,ny,visited);
            }
        }
    }


    public static void BFS()
    {
        Queue<Node> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(map[i][j] > 0)
                {
                    que.add(new Node(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while(!que.isEmpty())
        {
            Node temp = que.poll();
            int waterCnt = 0;
            for(int dir=0; dir<4; dir++)
            {
                int nx = temp.x + deltas[dir][0];
                int ny = temp.y + deltas[dir][1];
                if(nx < 0 || N <= nx || ny < 0 || M <= ny || visited[nx][ny])
                    continue;
                if(map[nx][ny] == 0)
                {
                    waterCnt++;
                }
            }
            if(map[temp.x][temp.y] - waterCnt < 0)
            {
                map[temp.x][temp.y] = 0;
            }
            else
            {
                map[temp.x][temp.y] -= waterCnt;
            }
        }


    }
}
