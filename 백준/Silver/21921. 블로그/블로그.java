import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=1; i<=N; i++)
        {
            if(i-X < 0)
                continue;
            if(max < sum[i]-sum[i-X])
            {
                max = sum[i]-sum[i-X];
                cnt=0;
            }
            if(max == sum[i]-sum[i-X])
            {
                cnt++;
            }
        }
        if(max == 0)
        {
            System.out.println("SAD");
        }
        else
        {
            System.out.println(max);
            System.out.println(cnt);
        }


    }
}
