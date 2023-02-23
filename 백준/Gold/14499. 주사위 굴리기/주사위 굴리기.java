
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class DICE{
        int x;
        int y;

        public DICE(int x, int y, int[][] number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        int[][] number;
    }

    static int N;
    static int M;
    static int C;
    static int[][] map;
    static int[][] deltas = {{},{0,1},{0,-1},{-1,0},{1,0}};
    static DICE dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int[][] diceNumber = new int[4][3];
        int diceX = Integer.parseInt(st.nextToken());
        int diceY = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
//        System.out.println("C" + C);
        dice = new DICE(diceX,diceY,diceNumber);
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int command = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
        {
//            System.out.println("????");
            command = Integer.parseInt(st.nextToken());
            int nx = dice.x + deltas[command][0];
            int ny = dice.y + deltas[command][1];
            if(nx<0 || N<=nx || ny<0 || M<=ny)
                continue;

            diceTop(command,nx,ny);
            dice.x = nx;
            dice.y = ny;
        }
    }

    public static void diceTop(int command, int nx, int ny){
        if(command == 1)
        {
            int temp = dice.number[1][0];
            dice.number[1][0] = dice.number[1][1];
            dice.number[1][1] = dice.number[1][2];
            dice.number[1][2] = dice.number[3][1];
            dice.number[3][1] = temp;
        }
        else if (command == 2)
        {
            int temp = dice.number[1][2];
            dice.number[1][2] = dice.number[1][1];
            dice.number[1][1] = dice.number[1][0];
            dice.number[1][0] = dice.number[3][1];
            dice.number[3][1] = temp;
        }
        else if (command == 3)
        {
            int temp = dice.number[0][1];
            dice.number[0][1] = dice.number[1][1];
            dice.number[1][1] = dice.number[2][1];
            dice.number[2][1] = dice.number[3][1];
            dice.number[3][1] = temp;
        }
        else if (command == 4)
        {
            int temp = dice.number[3][1];
            dice.number[3][1] = dice.number[2][1];
            dice.number[2][1] = dice.number[1][1];
            dice.number[1][1] = dice.number[0][1];
            dice.number[0][1] = temp;
        }
        if(map[nx][ny]==0)
        {
            map[nx][ny] = dice.number[3][1];
        }
        else
        {
            dice.number[3][1] = map[nx][ny];
            map[nx][ny] = 0;
        }
        System.out.println(dice.number[1][1]);

    }
}
