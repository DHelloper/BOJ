import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        int answer = 987654321;

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<3; k++)
        {
            for(int i=0; i<3; i++)
            {
                if(i==k) dp[1][i] = arr[1][i];
                else dp[1][i] = 987654321;
            }
            for(int i=2; i<=N; i++)
            {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
            }
            for(int i=0; i<3; i++)
            {
                if(i != k) answer = Math.min(answer, dp[N][i]);
            }
        }
        System.out.println(answer);
    }
}
