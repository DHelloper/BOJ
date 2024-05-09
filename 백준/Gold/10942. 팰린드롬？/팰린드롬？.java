import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++)
        {
            dp[i][i] = true;
        }
        for(int i=1; i<=N-1; i++)
        {
            if(arr[i]==arr[i+1]) dp[i][i+1] = true;
        }
        for(int i=2; i<N; i++)
        {
            for(int j=1; j<=N-i; j++)
            {
                if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]?1+"\n":0+"\n");
        }
        System.out.println(sb);
    }
}
