
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans_max;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board= new int[N][N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans_max = 0;
        bfs();
        System.out.println(ans_max);
    }
    public static void move(int[][] map, int dir)
    {
        boolean[][] visited = new boolean[N][N];

        int start = 0;
        int end = 0;
        int c = 0;
        if(dir == 0 || dir == 3)
        {
            start = 0;
            end = N;

            for(int j=start; j<end; j++)
            {
                for(int i=start; i<end; i++)
                {
                    if(map[i][j] == 0)
                        continue;
                    int x = i;
                    int y = j;
                    int temp = map[x][y];
                    map[x][y] = 0;
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    while(true)
                    {
                        if(nx < 0 || ny < 0 || N <= nx || N<= ny)
                        {
                            break;
                        }
                        if(map[nx][ny] == 0)
                        {
                            x = nx ;
                            y = ny ;
                            nx = x + dx[dir];
                            ny = y + dy[dir];
                        }
                        else if(!visited[nx][ny] && map[nx][ny] == temp)
                        {
                            x = nx;
                            y = ny;
                            visited[nx][ny] = true;
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                    map[x][y] += temp;
                }
            }
        }
        else
        {
            start = N-1;
            end = -1;
            for(int i=start;i>end;i--)
            {
                for(int j=start; j>end; j--)
                {
                    if(map[i][j] == 0)
                        continue;
                    int x = i;
                    int y = j;
                    int temp = map[x][y];
                    map[x][y] = 0;
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    while(true)
                    {
                        if(nx < 0 || ny < 0 || N <= nx || N <= ny)
                        {
                            break;
                        }

                        if(map[nx][ny] == 0)
                        {
                            x = nx;
                            y = ny;
                            nx = x + dx[dir];
                            ny = y + dy[dir];
                        }
                        else if(!visited[nx][ny] && map[nx][ny] == temp)
                        {
                            x = nx;
                            y = ny;
                            visited[nx][ny] = true;
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                    map[x][y] += temp;
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[][]> q = new ArrayDeque<>();
        q.offer(board);
        int cnt = 0;
        while(!q.isEmpty())
        {
            int q_len = q.size();
            for(int l=0;l<q_len;l++)
            {
                int[][] map = q.poll();

                for(int d=0; d<4; d++)
                {
                    int[][] map_copy = new int[N][N];
                    for(int i=0; i<N; i++)
                    {
                        for(int j=0; j<N; j++)
                        {
                            map_copy[i][j] = map[i][j];
                        }
                    }
                    move(map_copy, d);

                    q.offer(map_copy);
                    for(int i=0; i<N; i++)
                    {
                        for(int j=0; j<N; j++)
                        {
                            ans_max = Math.max(ans_max, map_copy[i][j]);
                        }
                    }
                }
            }
            cnt++;
            if(5<=cnt)
            {
                return;
            }
        }
    }
}
