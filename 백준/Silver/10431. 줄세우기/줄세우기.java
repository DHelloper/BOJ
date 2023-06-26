import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        for(int p=0; p<P; p++)
        {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int cnt=0;
            int[] arr = new int[20];
            for(int i=0; i<20; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<20; i++)
            {
                for(int j=0; j<i; j++)
                {
                    if(arr[j]>arr[i])
                        cnt++;
                }
            }
            System.out.println(T+" "+cnt);
        }
    }
}
