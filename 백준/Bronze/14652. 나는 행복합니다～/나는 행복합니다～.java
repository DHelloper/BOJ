import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int number = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {

                if(number==K)
                {
                    System.out.println(i+" "+j);
                    return;
                }
                number++;

            }
        }
    }
}
