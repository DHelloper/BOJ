
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            if(num==0)
            {
                if(pq.isEmpty())
                {
                    System.out.println("0");
                }
                else
                {
                    System.out.println(pq.poll());
                }
                continue;
            }
            pq.add(num);
        }

    }
}
