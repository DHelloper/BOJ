import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        int start;
        int end;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return weight-o.weight;
        }
    }

    public static int find(int x) {
        if(x == parent[x])
        {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x!=y)
        {
            parent[y] = x;
        }
    }
    static int N;
    static int M;

    static int[] parent;
    static ArrayList<Edge> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, weight));
        }
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            parent[i] = i;
        }
        Collections.sort(list);

        int ans = 0;
        int max = 0;
        for(int i=0; i<list.size(); i++)
        {
            Edge temp = list.get(i);
            if(find(temp.start) != find(temp.end))
            {
                ans += temp.weight;
                union(temp.start, temp.end);

                max = temp.weight;
            }
        }
        System.out.println(ans-max);
    }
}
