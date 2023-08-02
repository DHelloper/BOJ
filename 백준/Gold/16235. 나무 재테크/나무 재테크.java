import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] food = new int[11][11];
    static int[][] foodToBeAdded = new int[11][11];
    static int[][] deadTree = new int[11][11];
    static Deque<Tree> liveTree = new ArrayDeque<>();
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                food[i][j] = 5;
                foodToBeAdded[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            liveTree.add(new Tree(x, y, age));
        }

        for (int i = 1; i <= K; i++) {
            // spring
            int len = liveTree.size();
            for (int j = 0; j < len; j++) {
                Tree t = liveTree.pollFirst();
                if (t == null) {
                    break;
                }
                if (food[t.r][t.c] >= t.age) {
                    food[t.r][t.c] -= t.age;
                    t.age++;
                    liveTree.addLast(t);
                } else {
                    deadTree[t.r][t.c] += t.age / 2;
                }
            }

            // summer
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    food[j][k] += deadTree[j][k];
                    deadTree[j][k] = 0;
                }
            }

            // fall
            Deque<Tree> tmp = new ArrayDeque<>();
            while (!liveTree.isEmpty()) {
                Tree t = liveTree.pollFirst();
                tmp.addLast(t);
                if (t.age % 5 == 0) {
                    for (int k = 0; k < 8; k++) {
                        int nr = t.r + delta[k][0];
                        int nc = t.c + delta[k][1];
                        if (nr < 1 || nc < 1 || nr > N || nc > N) {
                            continue;
                        }
                        tmp.addFirst(new Tree(nr, nc, 1));
                    }
                }
            }
            liveTree = tmp;

            // winter
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    food[j][k] += foodToBeAdded[j][k];
                }
            }
        }

        System.out.print(liveTree.size());
    }

    static class Tree {
        int r, c, age;
        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
}
