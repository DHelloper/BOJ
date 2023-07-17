import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class fire{
        int r,c;
        int m;
        int d;
        int s;
        int cnt;
        int[] dirs;
        public fire(int r, int c, int m, int s,int d) {
            super();
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.cnt = 0;
            dirs = new int[2];
        }
    }

    static int N,M,K;
    static int[][] deltas = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static Queue<fire> que = new ArrayDeque<>();
    static fire[][] balls = new fire[50][50];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        /**
         * 맵 크기 N
         * 파이어볼의 갯수 M
         * 명령의 갯수 K
         * ball객체로 만들어서 관리
         *
         */
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            que.add(new fire(r,c,m,s,d));
        }

        for(int i=0; i<K; i++) {
            move();
        }
        int sum=0;
        while(!que.isEmpty()) {
            sum+= que.poll().m;
        }
        System.out.println(sum);
    }

    public static void move() {

        while (!que.isEmpty()) {
            fire temp = que.poll();
            temp.r = (temp.r + deltas[temp.d][0]*temp.s)%N;
            temp.c = (temp.c + deltas[temp.d][1]*temp.s)%N;

            if(temp.r < 0)
            {
                temp.r += N;
            }
            if(temp.c < 0)
            {
                temp.c += N;
            }
            if(balls[temp.r][temp.c] == null)
            {
                balls[temp.r][temp.c] = new fire(temp.r,temp.c,0,0,0);
            }
            balls[temp.r][temp.c].cnt++;
            balls[temp.r][temp.c].m += temp.m;
            balls[temp.r][temp.c].s += temp.s;
            balls[temp.r][temp.c].d += temp.d;
            balls[temp.r][temp.c].dirs[temp.d%2]=1;
        }
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(balls[i][j] == null)
                    continue;
                fire temp = balls[i][j];
                balls[i][j] = null;
                if(temp.cnt == 1)
                {
                    que.add(new fire(i,j,temp.m,temp.s,temp.d));
                    continue;
                }
                if(temp.m / 5 == 0)
                {
                    continue;
                }

                int type = temp.dirs[0] == 1 && temp.dirs[1] ==1 ? 1:0;
                for(int k=0; k<4; k++)
                {
                    que.add(new fire(i,j,temp.m/5, temp.s/temp.cnt, k*2+type));
                }
            }
        }
    }
}
