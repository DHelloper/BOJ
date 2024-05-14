import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] visited;
    static char[][] map;
    static Queue<int[]> que;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        que = new ArrayDeque<>();
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<N; j++)
            {
                map[i][j] = str.charAt(j);
            }
        }
        int cnt=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!visited[i][j])
                {
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                    cnt++;
                    BFS();
                }
            }
        }
        visited = new boolean[N][N];
        int cnt2=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!visited[i][j])
                {
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                    cnt2++;
                    BFS2();
                }
            }
        }
        System.out.println(cnt);
        System.out.println(cnt2);

    }
    public static void BFS()
    {
        while(!que.isEmpty())
        {
            int[] temp = que.poll();
            for(int dir=0; dir<4; dir++)
            {
                int dx = temp[0]+deltas[dir][0];
                int dy = temp[1]+deltas[dir][1];
                if(dx<0||dy<0||dx>=N||dy>=N||visited[dx][dy]||map[dx][dy]!=map[temp[0]][temp[1]]) continue;
                visited[dx][dy] = true;
                que.add(new int[]{dx,dy});
            }
        }
    }
    public static void BFS2()
    {
        while(!que.isEmpty())
        {
            int[] temp = que.poll();
            for(int dir=0; dir<4; dir++)
            {
                int dx = temp[0]+deltas[dir][0];
                int dy = temp[1]+deltas[dir][1];
                if(dx<0||dy<0||dx>=N||dy>=N||visited[dx][dy]) continue;
                if(map[temp[0]][temp[1]]=='R' || map[temp[0]][temp[1]]=='G'){
                    if(map[dx][dy]=='B') continue;
                }
                else {
                    if(map[temp[0]][temp[1]]!=map[dx][dy]) continue;
                }

                visited[dx][dy] = true;
                que.add(new int[]{dx,dy});
            }
        }
    }
}
