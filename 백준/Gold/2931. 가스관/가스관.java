import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int ansR, ansC, tempR, tempC;
    static char ansType;
    static int K;
    static boolean visited[][];
    static char arr[] = {' ','|','-','+','1','2','3','4'};
    static boolean flag=false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int startR = 0;
        int startC = 0;
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'M')
                {
                    startR = i;
                    startC = j;
                }
                if(map[i][j]!='Z' && map[i][j]!= 'M' && map[i][j]!='.')
                {
                    K++;
                }
            }
        }
        K++;
        for(int dir=0; dir<4; dir++)
        {
            int nr = startR+deltas[dir][0];
            int nc = startC+deltas[dir][1];
            if(nr<0 || N<=nr || nc<0 || M<=nc)
                continue;
            dfs(nr,nc,dir,0,true);
        }
        ansR+=1;
        ansC+=1;
        System.out.println(ansR+" "+ansC+" "+ansType);
    }
    static void dfs(int r, int c, int d, int cnt, boolean use) {
        if(flag) return;
        if(cnt==K) {
            ansR=tempR;
            ansC=tempC;
            ansType=map[ansR][ansC];
            flag = true;
            return;
        }
        int nd = change(d, map[r][c]);
        if(nd==-1) return;
        int nr = r+deltas[nd][0];
        int nc = c+deltas[nd][1];
        if(nr<0 || nr>=N | nc<0 ||nc>=M) return;
        if(map[nr][nc]=='.') {
            if(use==true) {
                //1~7까지 구하기
                for(int i=1; i<8; i++) {
                    tempR=nr; tempC=nc;
                    map[nr][nc] = arr[i];
                    visited[nr][nc] = true;
                    dfs(nr, nc, nd, cnt+1, false);
                    map[nr][nc] ='.';
                    visited[nr][nc] = false;
                }
            }
        }else {
            if(visited[nr][nc]) {
                dfs(nr, nc, nd, cnt, use);
            }else {
                visited[nr][nc] = true;
                dfs(nr, nc, nd, cnt+1, use);
                visited[nr][nc] = false;
            }
        }
    }
    static int change(int d, char pipe) {
        if(pipe=='|') {
            if(d==0 || d==2) return d;
        }else if(pipe =='-') {
            if(d==1 || d==3) return d;
        }else if(pipe =='+') {
            return d;
        }else if(pipe=='1') {
            if(d==3) return 2;
            if(d==0) return 1;
        }else if(pipe=='2') {
            if(d==2) return 1;
            if(d==3) return 0;
        }else if(pipe=='3') {
            if(d==1) return 0;
            if(d==2) return 3;
        }else if(pipe=='4') {
            if(d==1) return 2;
            if(d==0) return 3;
        }
        return -1;
    }
}
