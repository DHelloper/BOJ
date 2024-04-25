import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            if(max.size()==min.size()) {
                max.add(num);
                if(!min.isEmpty() && max.peek()>min.peek())
                {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            }
            else
            {
                min.add(num);
                if(max.peek()>min.peek())
                {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
