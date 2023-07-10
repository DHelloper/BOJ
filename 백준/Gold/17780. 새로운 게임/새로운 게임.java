import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class Node
    {
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
    static int N;
    static int K;
    static int[][] color;
    static int[][] horse;
    static int[][] deltas={{0,1},{1,0},{0,-1},{-1,0}};
    static LinkedList<Node>[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        color = new int[N][N];
        horse = new int[K][2];
        map = new LinkedList[N][N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                map[i][j] = new LinkedList<>();
            }
        }
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            if(dir==1) dir = 0;
            else if (dir==4) dir=1;
            horse[i][0] = x;
            horse[i][1] = y;
            map[x][y].add(new Node(i,dir));
        }
        game();

    }
    public static void game()
    {
        for(int t=1; t<=1000; t++)
        {
            for(int k=0; k<K; k++)
            {
                int x = horse[k][0];
                int y = horse[k][1];
                int d = map[x][y].get(0).d;
                if(map[x][y].get(0).n != k)
                    continue;

                int nx = x + deltas[d][0];
                int ny = y + deltas[d][1];

                if(nx<0 || N <= nx || ny<0 || N <= ny || color[nx][ny] == 2) {
                    map[x][y].get(0).d = d = (d + 2) % 4;
                    nx = x + deltas[d][0];
                    ny = y + deltas[d][1];
                    if (nx < 0 || N <= nx || ny < 0 || N <= ny || color[nx][ny] == 2) {
                        continue;
                    }
                    else
                    {
                        if (move(x, y, nx, ny, color[nx][ny])) {
                            System.out.println(t);
                            return;
                        }
                    }
                }
                else
                {
                    if(move(x,y,nx,ny,color[nx][ny]))
                    {
                        System.out.println(t);
                        return;
                    }
                }
            }
        }
        System.out.println("-1");
    }

    public static boolean move(int px, int py, int nx, int ny, int color)
    {
        if(color == 0)
        {
            while(map[px][py].size() > 0)
            {
                Node temp = map[px][py].removeFirst();
                horse[temp.n][0] = nx;
                horse[temp.n][1] = ny;
                map[nx][ny].add(temp);
            }
        }
        else
        {
            while(map[px][py].size() > 0)
            {
                Node temp = map[px][py].removeLast();
                horse[temp.n][0] = nx;
                horse[temp.n][1] = ny;
                map[nx][ny].add(temp);
            }
        }
        if(map[nx][ny].size() >= 4) return true;
        else return false;
    }
}
