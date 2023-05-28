import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> student = new ArrayList<>();
    static int N;
    static char[][] map;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    student.add(new Node(i, j));
                }
            }
        }
        if(DFS(0))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static boolean DFS(int cnt) {
        if (cnt == 3) {
            if(BFS())
                return true;
            else
                return false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    if(DFS(cnt + 1))
                        return true;
                    map[i][j] = 'X';
                }
            }
        }
        return false;
    }

    public static boolean BFS() {

        Queue<Node> que = new ArrayDeque<>();
        char[][] copyMap = new char[N][N];
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 'T') {
                    que.add(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Node temp = que.poll();
            int x = temp.x;
            int y = temp.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + deltas[dir][0];
                int ny = y + deltas[dir][1];

                while(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (copyMap[nx][ny] != 'O') {
                        check[nx][ny] = true;
                        nx += deltas[dir][0];
                        ny += deltas[dir][1];
                    }
                    else{
                        break;
                    }
                }
            }
        }
        if(catchStudent(check)){
            return true;
        }
        return false;
    }

    public static boolean catchStudent(boolean[][] check) {
        for (Node node : student) {
            if (check[node.x][node.y] == true) {
                return false;
            }
        }
        return true;
    }
}
