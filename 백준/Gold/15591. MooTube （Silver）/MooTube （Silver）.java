
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
                    "start=" + start +
                    ", end=" + end +
                    ", r=" + r +
                    '}';
        }

        public Node(int start, int end, int r) {
            this.start = start;
            this.end = end;
            this.r = r;
        }

        int start;
        int end;
        int r;
    }
    static int N;
    static int Q;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=1; i<=N; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[start].add(new Node(start,end,r));
            list[end].add(new Node(end,start,r));
//            System.out.println(list[start].get(0).toString());
//            System.out.println(list[end].get(0).toString());
        }
        for(int i=0; i<Q; i++)
        {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            BFS(k,v);
        }
    }
    public static void BFS(int k, int v)
    {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        visited[v] = true;
        que.add(v);
        int cnt=0;
        while(!que.isEmpty())
        {
            int temp = que.poll();
            for(int i=0; i<list[temp].size(); i++)
            {
                if(!visited[list[temp].get(i).end] && list[temp].get(i).r >= k)
                {
                    que.add(list[temp].get(i).end);
                    visited[list[temp].get(i).end] = true;
//                    System.out.println(temp+"에서 "+list[temp].get(i).end+"까지 거리 :"+list[temp].get(i).r);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
