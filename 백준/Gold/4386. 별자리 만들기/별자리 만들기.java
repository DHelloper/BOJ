import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int num;
        double x;
        double y;
        public Node(int num, double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int to;
        int from;
        double weight;
        public Edge(int to, int from, double weight)
        {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight<o.weight)
                return -1;
            return 1;
        }
    }
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
    static int[] parent;
    static ArrayList<Edge> list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(i,x,y);
        }
        list = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                double weight = Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
                list.add(new Edge(i,j,weight));
            }
        }
        Collections.sort(list);
        parent = new int[N];
        for(int i=0; i<N; i++)
            parent[i]=i;
        double answer = 0;
        for(int i=0; i < list.size(); i++)
        {
            Edge edge = list.get(i);
            if(find(edge.to)!=find(edge.from)){
                answer += edge.weight;
                union(edge.to,edge.from);
            }
        }
        System.out.println(answer);

    }
}
