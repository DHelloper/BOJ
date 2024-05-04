import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Robot{
        int x;
        int y;
        int dir;
        public Robot(int x, int y, int dir)
        {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int A,B,N,M;
    static int[][] map;
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean exit = false;
    static ArrayList<Robot> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B][A];
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list.add(new Robot(-1,-1,-1));
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            String d = st.nextToken();
            int tempDir = -1;
            if(d.equals("N")) tempDir = 0;
            else if(d.equals("E")) tempDir = 1;
            else if(d.equals("S")) tempDir = 2;
            else if(d.equals("W")) tempDir = 3;
            list.add(new Robot(x,y,tempDir));
            map[y][x] = i+1;
        }
//        printArr();
//        System.out.println();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            String com = st.nextToken();
            int loof = Integer.parseInt(st.nextToken());
            if(com.equals("L")) turnLeft(index,loof);
            else if(com.equals("R")) turnRight(index,loof);
            else if(com.equals("F")) go(index,loof);
            if(exit) break;
//            printArr();
//            System.out.println();

        }
        if(!exit) System.out.println("OK");

    }

    public static void turnLeft(int index, int loof)
    {
        for(int i=0; i<loof; i++)
        {
            int dir = list.get(index).dir;
            if(dir == 0) list.get(index).dir = 3;
            else list.get(index).dir -= 1;
        }
    }
    public static void turnRight(int index, int loof)
    {
        for(int i=0; i<loof; i++)
        {
            int dir = list.get(index).dir;
            if(dir == 3) list.get(index).dir = 0;
            else list.get(index).dir += 1;
        }
    }
    public static void go(int index,int loof)
    {
        int nx = list.get(index).x;
        int ny = list.get(index).y;
        int dir = list.get(index).dir;
        for(int i=0; i<loof; i++)
        {
//            System.out.println("xy : "+nx+" "+ny);
            nx += deltas[dir][0];
            ny += deltas[dir][1];
//            System.out.println("nxny : "+nx+" "+ny);
//            System.out.println(ny);
            if(nx<0 || A<=nx || ny<0 || B<=ny){
                System.out.println("Robot "+index+" crashes into the wall");
                exit = true;
                return;
            }
            if(map[ny][nx]!=0) {
                System.out.println("Robot "+index+" crashes into robot "+map[ny][nx]);
                exit = true;
                return;
            }
            map[list.get(index).y][list.get(index).x] = 0;
            map[ny][nx] = index;
            list.get(index).x = nx;
            list.get(index).y = ny;
        }
    }

    public static void printArr(){
        for(int i=0; i<B; i++)
        {
            for(int j=0; j<A; j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
