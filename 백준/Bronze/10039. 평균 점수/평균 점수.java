import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int result=0;
        for(int i=0; i<5; i++)
        {
           arr[i] = Integer.parseInt(br.readLine());
           if(arr[i] < 40)
           {
               arr[i] = 40;
           }
           result+=arr[i];
        }
        System.out.println(result/5);

    }
}
