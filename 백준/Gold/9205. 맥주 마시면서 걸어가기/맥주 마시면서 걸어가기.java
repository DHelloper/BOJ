import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static boolean[] visited;
    static List<Node> list;
    static Node start,end;
    static Queue<Node> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            visited = new boolean[N];
            que = new ArrayDeque<>();
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            que.add(start);
            BFS();
        }
    }

    public static void BFS(){
        while(!que.isEmpty())
        {
            Node temp = que.poll();
            if(Math.abs(temp.x-end.x)+Math.abs(temp.y-end.y)<=1000){
                System.out.println("happy");
                return;
            }
            for(int i=0; i<list.size();i++)
            {
                if(!visited[i]){
                    Node next = list.get(i);
                    if(Math.abs(temp.x-next.x)+Math.abs(temp.y-next.y)<=1000){
                        visited[i] = true;
                        que.add(next);
                    }
                }
            }
        }
        System.out.println("sad");
        return;
    }
}
