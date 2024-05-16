import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int x;
        int y;
        int count;
        public Point(int x, int y, int count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N;
    static int[][] map;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    static Queue<Point> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        que = new ArrayDeque<>();
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        land();
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] > 0) {
                    visited = new boolean[N][N];
                    int res = bridge(j,i);

                    if(res == -1 )continue;
                    if(min > res) {
                        min = res;
                    }
                }
            }
        }
        System.out.println(min-1);
    }

    static int bridge(int x, int y) {
        que = new LinkedList<>();

        int num = map[y][x];
        visited[y][x] =true;
        que.add(new Point(x,y,0));

        while(!que.isEmpty()) {
            Point temp = que.poll();
            int px = temp.x;
            int py = temp.y;
            int cnt = temp.count;

            if(map[py][px] != 0 && map[py][px] != num) {
                return cnt;
            }

            for(int d=0; d<4; d++) {
                int nx = px + deltas[d][0];
                int ny = py + deltas[d][1];

                if(nx<0 || N<=nx || ny <0 || N<=ny) continue;
                if(visited[ny][nx] || map[ny][nx] == num) continue;

                visited[ny][nx] = true;
                que.add(new Point(nx,ny, cnt+1));
            }

        }
        return -1;

    }

    static void land() {

        int idx = 2;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = idx;
                    visited[i][j] =true;
                    que.add(new Point(j,i,0));

                    while(!que.isEmpty()) {
                        Point temp = que.poll();
                        int px = temp.x;
                        int py = temp.y;

                        for(int d=0; d<4; d++) {
                            int nx = px + deltas[d][0];
                            int ny = py + deltas[d][1];

                            if(nx<0 || N<=nx || ny <0 || N<=ny) continue;
                            if(visited[ny][nx]) continue;

                            if(map[ny][nx] == 1) {
                                visited[ny][nx] = true;
                                map[ny][nx] = idx;
                                que.add(new Point(nx,ny,0));
                            }
                        }
                    }
                    idx++;
                }
            }
        }
    }
}
