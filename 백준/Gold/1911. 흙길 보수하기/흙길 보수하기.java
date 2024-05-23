import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Info implements Comparable<Info> {
        int s;
        int e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            if (this.s == o.s)
                return o.e - this.e;
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<Info> pq = new PriorityQueue<>();	
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Info(x, y));
        }
        int result = 0;	
        int fill = 0;	
        while(!pq.isEmpty())
        {
            Info temp = pq.poll();
            if(temp.e < fill)
                continue;
            if(fill < temp.s)
                fill = temp.s;

            int remain = (temp.e - fill) % L;
            result += (temp.e-fill)/L;
            fill = temp.e;
            if(remain != 0){
                result++;
                fill += L - remain;
            }
        }
        System.out.println(result);
    }
}

