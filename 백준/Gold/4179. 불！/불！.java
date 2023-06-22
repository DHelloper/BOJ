
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

    }
    static int N;
    static int M;
    static int cnt;
    static int[][] deltas={{-1,0},{0,1},{1,0},{0,-1}};
    static char[][] map;
    static Queue<Node> fire = new ArrayDeque<>();
    static boolean[][] visited_jihun;
    static boolean[][] visited_fire;
    static Queue<Node> jihun = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited_jihun = new boolean[N][M];
        visited_fire = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J')
                {
                    jihun.add(new Node(i,j));
                }
                else if(map[i][j] == 'F')
                {
                    fire.add(new Node(i,j));
                }
//                System.out.print(map[i][j] + " ");
            }
        }
//        printall();
        move();

    }

    public static void move()
    {
        while(!jihun.isEmpty())
        {
            int fireLength = fire.size();
            int jihunLength = jihun.size();
            for(int i=0; i<fireLength; i++)
            {
                Node temp_fire = fire.poll();
                for(int dir=0; dir<4; dir++)
                {
                    int nx = temp_fire.x + deltas[dir][0];
                    int ny = temp_fire.y + deltas[dir][1];
                    if(nx < 0 || N <= nx || ny < 0 || M <= ny || map[nx][ny]=='#' || visited_fire[nx][ny])
                        continue;
                    map[nx][ny] = 'F';
                    visited_fire[nx][ny] = true;
                    fire.add(new Node(nx,ny));
                }
            }
            for(int i=0; i<jihunLength; i++)
            {
                Node temp = jihun.poll();
                for(int dir=0; dir<4; dir++)
                {
                    int nx = temp.x + deltas[dir][0];
                    int ny = temp.y + deltas[dir][1];
//                    if(nx < 0 || N <= nx || ny < 0 || M <= ny || map[nx][ny]=='#' || map[nx][ny]=='F' || visited_jihun[nx][ny])
//                        continue;
                    if(nx < 0 || N <= nx || ny < 0 || M <= ny)
                    {
                        cnt++;
                        System.out.println(cnt);
                        return;
                    }
                    if(map[nx][ny] !='.' || visited_jihun[nx][ny]) continue;

                    map[nx][ny] = 'J';
                    visited_jihun[nx][ny] = true;
                    jihun.add(new Node(nx,ny));

                }
            }
            cnt++;
//            printall();
//            System.out.println();
//            if(check())
//            {
//                System.out.println(cnt+1);
//                return;
//            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static boolean check()
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if((i==0 || i == N-1 || j == 0 || j == M-1) && map[i][j] == 'J')
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printall()
    {
        for (int i=0 ;i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
