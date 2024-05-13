import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class sang{
        int x;
        int y;
        int l;
        int count;
        public sang(int l, int x, int y, int count){
            this.l = l;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int N;
    static int M;
    static int L;
    static char[][][] map;
    static boolean[][][] visited;
    static int[][] deltas = {{-1,0,0},{1,0,0},{0,-1,0},{0,0,1},{0,1,0},{0,0,-1}};
    static Queue<sang> que;
    static sang end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(L == 0 && N == 0 && M == 0) break;
            que = new ArrayDeque<>();
            map = new char[L][N][M];
            visited = new boolean[L][N][M];
            for(int i=0; i<L; i++)
            {
                for(int j=0; j<N; j++)
                {
                    String str = br.readLine();
                    for(int k=0; k<M; k++)
                    {
                        map[i][j][k] = str.charAt(k);
                        if(map[i][j][k] == 'S') que.add(new sang(i,j,k,0));
                        else if(map[i][j][k]=='E') end = new sang(i,j,k,0);
                    }
                }
                br.readLine();
            }
            int min=Integer.MAX_VALUE;
            boolean check=false;
            A:while(!que.isEmpty()){
                sang temp = que.poll();
                for(int dir=0; dir<6; dir++)
                {
                    int dl = temp.l+deltas[dir][0];
                    int dx = temp.x+deltas[dir][1];
                    int dy = temp.y+deltas[dir][2];

                    if(dl<0 || L <= dl || dx < 0 || N <= dx || dy < 0 || M <= dy || visited[dl][dx][dy] || map[dl][dx][dy]=='#') continue;
                    if(map[dl][dx][dy]=='E') {
                        check = true;
                        min = Math.min(min, temp.count+1);
                        break A;
                    }
                    visited[dl][dx][dy] = true;
                    que.add(new sang(dl,dx,dy,temp.count+1));
                }
            }
            if(check) System.out.println("Escaped in "+min+" minute(s).");
            else System.out.println("Trapped!");
        }
    }
}
