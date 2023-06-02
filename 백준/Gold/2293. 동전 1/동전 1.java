import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N+1];
        int[] dp = new int[K+1];
        dp[0] = 1;

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++)
        {
            for(int j=coin[i]; j<=K; j++)
            {
//                System.out.println("?");
                dp[j] = dp[j] + dp[j-coin[i]];
            }
        }
        System.out.println(dp[K]);
    }
}
