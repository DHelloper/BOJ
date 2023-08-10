
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = 0;
        int B = 0;
        for(int i=0; i<4; i++)
        {
            A+=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
        {
            B+=Integer.parseInt(st.nextToken());
        }
        if(A>=B)
            System.out.println(A);
        else
            System.out.println(B);
    }
}
