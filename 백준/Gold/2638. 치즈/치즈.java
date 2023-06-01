import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node
    {
        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[][] air;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int result;
    static int cheeseCnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1)
                {
                    cheeseCnt++;
                }
            }
        }
        while(cheeseCnt != 0)
        {
            BFS();
        }

        System.out.println(result);
    }

    public static void BFS() {
        air = new int[N][M];

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0,0));
        air[0][0] = -1;

        while(!que.isEmpty())
        {
            Node temp = que.poll();
            for(int dir=0; dir<4; dir++)
            {
                int nx = temp.x + deltas[dir][0];
                int ny = temp.y + deltas[dir][1];
                if(nx<0 || N <= nx || ny < 0 || M <= ny)
                    continue;
                if(map[nx][ny] == 1)
                    air[nx][ny]++;
                if(map[nx][ny] == 0 && air[nx][ny] == 0)
                {
                    air[nx][ny] = -1;
                    que.add(new Node(nx,ny));
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(air[i][j] >= 2){
                    cheeseCnt--;
                    map[i][j] = 0;
                }
            }
        }
        result++;
    }
}
