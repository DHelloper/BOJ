import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(a,b);
            max = Math.max(max,c);
//            System.out.println(a+" "+b+" "+c);
            if(a==0 && b==0 && c==0)
            {
                break;
            }
//            System.out.println(max+max-a-b-c);
            if(max+max-a-b-c>=0)
            {
                System.out.println("Invalid");
                continue;
            }
            if(a==b && b==c)
            {
                System.out.println("Equilateral");
                continue;
            }
            if((a==b && b!=c) || (a!=b && b==c) || (a==c && b!=c))
            {
                System.out.println("Isosceles");
                continue;
            }
            if(a!=b && b!=c)
            {
                System.out.println("Scalene");
                continue;
            }
        }
    }
}
