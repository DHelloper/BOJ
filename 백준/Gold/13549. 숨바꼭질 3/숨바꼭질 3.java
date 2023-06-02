
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Subin
    {
        public Subin(int x, int time) {
            this.x = x;
            this.time = time;
        }

        int x;
        int time;
    }
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N==K)
        {
            System.out.println(0);
            return;
        }
        BFS(N);
        System.out.println(result);
    }
    public static void BFS(int start)
    {
        Queue<Subin> que = new LinkedList<>();
        que.add(new Subin(start, 0));
        visited[start] = true;
        while(!que.isEmpty())
        {
            Subin temp = que.poll();

            if(temp.x == K)
            {
                result = Math.min(result, temp.time);
            }
            int next;
            next = temp.x * 2;
            if(next < 100001 && !visited[next])
            {
                visited[next] = true;
                que.add(new Subin(next,temp.time));
            }

            next = temp.x - 1;
            if(0 <= next && !visited[next])
            {
                visited[next] = true;
                que.add(new Subin(next, temp.time+1));
            }

            next = temp.x + 1;
            if(next < 100001 && !visited[next])
            {
                visited[next] = true;
                que.add(new Subin(next,temp.time+1));
            }
        }
    }
}
