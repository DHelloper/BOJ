import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken()) - N;
        int B = Integer.parseInt(st.nextToken()) - N;
        if(A==B)
        {
            System.out.println("Anything");
        }
        else if(A>B)
        {
            System.out.println("Subway");
        }
        else if(A<B)
        {
            System.out.println("Bus");
        }

    }
}
