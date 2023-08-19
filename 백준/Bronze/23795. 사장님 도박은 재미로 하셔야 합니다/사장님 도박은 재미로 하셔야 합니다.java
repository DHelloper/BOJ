import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        while(true)
        {
            int temp = Integer.parseInt(br.readLine());
            if(temp == -1)
                break;
            sum+=temp;
        }
        System.out.println(sum);
    }
}
