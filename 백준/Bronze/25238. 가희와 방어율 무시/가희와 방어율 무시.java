
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a<100) {
            System.out.println("1");
            return;
        }
        double c = a*(b*0.01);
        double d = a-c;
        if(d<100)
            System.out.println("1");
        else
            System.out.println("0");

    }
}
