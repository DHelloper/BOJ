import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static public class Node{
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        int to;
        int cost;
    }
    static int N;
    static int M;
    static int[] d;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N];
        d = new int[N];
        for(int i=0; i<N; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
            list[end].add(new Node(start,weight));
        }
        dijkstra(0);
        System.out.println(d[N-1]);
    }

    public static void dijkstra(int start)
    {
        PriorityQueue<Node> que = new PriorityQueue<>((a,b)->a.cost-b.cost);

        Arrays.fill(d, Integer.MAX_VALUE);
        que.add(new Node(start, 0));
        d[start] = 0;
        while(!que.isEmpty())
        {
            Node temp = que.poll();
            int curCost = temp.cost;
            int curTo = temp.to;

            if(curCost > d[curTo])
                continue;
            for(Node next : list[curTo])
            {
                int cost = d[curTo] + next.cost;
                if(d[next.to] > cost)
                {
                    d[next.to] = cost;
                    que.add(new Node(next.to, cost));
                }
            }
        }
    }
}
