
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Plate{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Plate(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][] map;
    static boolean[][][][] visited;
    static int N;
    static int M;
    static int holeX;
    static int holeY;
    static Plate red;
    static Plate blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        for(int i=0; i<N; i++)
        {
            char[] inputCharArray = br.readLine().toCharArray();
            for(int j=0; j<M; j++)
            {
                map[i][j] = inputCharArray[j];
                if(map[i][j]=='O')
                {
                    holeX = i;
                    holeY = j;
                }
                else if(map[i][j]=='B')
                {
                    blue = new Plate(0,0,i,j,0);
                }
                else if(map[i][j] == 'R')
                {
                    red = new Plate(i,j,0,0,0);
                }
            }
        }
//        printarr();
        System.out.println(bfs());
    }

    public static int bfs()
    {
        Queue<Plate> que = new ArrayDeque<>();
        que.add(new Plate(red.rx,red.ry, blue.bx, blue.by,1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!que.isEmpty())
        {
            Plate tempPlate = que.poll();

            int curRx = tempPlate.rx;
            int curRy = tempPlate.ry;
            int curBx = tempPlate.bx;
            int curBy = tempPlate.by;
            int curCnt = tempPlate.cnt;

            if(curCnt > 10) { // 이동 횟수가 10 초과시 실패
                return -1;
            }

            for(int dir=0; dir<4; dir++)
            {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(map[newRx + deltas[dir][0]][newRy + deltas[dir][1]]!='#')
                {
                    newRx += deltas[dir][0];
                    newRy += deltas[dir][1];
                    if(newRx == holeX && newRy == holeY)
                    {
                        isRedHole=true;
                        break;
                    }
                }

                while(map[newBx + deltas[dir][0]][newBy + deltas[dir][1]]!='#')
                {
                    newBx += deltas[dir][0];
                    newBy += deltas[dir][1];
                    if(newBx == holeX && newBy == holeY)
                    {
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole)
                {
                    continue;
                }
                if(isRedHole&&!isBlueHole)
                {
                    return curCnt;
                }
                if(newRx == newBx && newRy == newBy)
                {
                    //위쪽 방향일 때, x가 큰사람이 뒤로
                    if(dir==0)
                    {
                        if(curRx > curBx)
                        {
                            newRx -= deltas[dir][0];
                        }
                        else
                        {
                            newBx -= deltas[dir][0];
                        }
                    }
                    //오른쪽인 경우, y가 작은 게 뒤로 감
                    else if(dir==1)
                    {
                        if(curRy > curBy)
                        {
                            newBy -= deltas[dir][1];
                        }
                        else
                        {
                            newRy -= deltas[dir][1];
                        }
                    }
                    //아래쪽인 경우, x가 작은게 뒤로 감
                    else if(dir==2)
                    {
                        if(curRx < curBx)
                        {
                            newRx -= deltas[dir][0];
                        }
                        else
                        {
                            newBx -= deltas[dir][0];
                        }
                    }
                    // 왼쪽인 경우, y가 큰게 뒤로 감
                    else if(dir==3)
                    {
                        if(curRy > curBy)
                        {
                            newRy -= deltas[dir][1];
                        }
                        else
                        {
                            newBy -= deltas[dir][1];
                        }
                    }
                }
                if(!visited[newRx][newRy][newBx][newBy])
                {
                    visited[newRx][newRy][newBx][newBy] = true;
                    que.add(new Plate(newRx,newRy,newBx,newBy,curCnt+1));
                }
            }
        }
        return -1;
    }
    public static void printarr(){
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
