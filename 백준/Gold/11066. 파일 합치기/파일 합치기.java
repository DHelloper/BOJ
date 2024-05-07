import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp;
        int[] arr;
        int[] sum;
        int N;
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dp = new int[N+1][N+1];
            arr = new int[N+1];
            sum = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1]+arr[i];
            }
            for (int i=1; i<=N; i++) {
                for (int j=1; j+i <= N; j++) {
                    int k = j + i;
                    dp[j][k] = 214748364;
                    for (int x = j; x < k; x++) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][x] + dp[x + 1][k] + sum[k] - sum[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][N]);
        }
    }
}
