import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mod = 10007;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N+1];
        int dp[][] = new int[N+1][H+1];
        dp[0][0] = 1;
        for(int i=0; i<=N; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                list[i].add(Integer.parseInt(st.nextToken()));
        }
        for(int i=1; i<=N; i++){
            dp[i][0] = 1;
            for(int j=1; j<=H; j++){
                for(int k=0; k<list[i].size() ;k++){
                    if(j - list[i].get(k) < 0)
                        continue;

                    dp[i][j] += dp[i-1][j-list[i].get(k)];
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= mod;
            }
        }
        System.out.println(dp[N][H]);
    }
}
