import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist)
        {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Node> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(e > D)
                continue;
            if(e-s > d)
                list.add(new Node(s,e,d));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.start == o2.start)
                    return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });

        int[] distance = new int[D+1];
        int move = 0;
        int index = 0;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        while(move < D)
        {
            if(index < list.size())
            {
                Node temp = list.get(index);
                if(move == temp.start) {
                    distance[temp.end] = Math.min(distance[move]+temp.dist,distance[temp.end]);
                    index++;
                }
                else {
                    distance[move+1] = Math.min(distance[move+1], distance[move]+1);
                    move++;
                }
            }
            else {
                distance[move+1] = Math.min(distance[move+1], distance[move]+1);
                move++;
            }
        }
        System.out.println(distance[D]);
    }
}
