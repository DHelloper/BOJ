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
        int[][] arr = new int[N][2];

        int answer = 0;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1,o2) ->
        {
            return o1[0] - o2[0];
        });
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++)
        {
            dp[i] = 1;
            for(int j=0; j<i; j++)
            {
                if(arr[i][1] > arr[j][1])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(N-answer);
    }
}
