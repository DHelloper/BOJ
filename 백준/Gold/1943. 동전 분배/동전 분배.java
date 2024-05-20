import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class coin{
        int value;
        int cnt;
        public coin(int value,int cnt){
            this.value = value;
            this.cnt = cnt;
        }

    }
    static int N;
    static int total;
    static coin[] coins;
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=0; t<3; t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            coins = new coin[N+1];
            dp = new boolean[100001];
            total = 0;
            for(int i=1; i<=N; i++)
            {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                coins[i] = new coin(value,cnt);
                total+=value*cnt;
                for(int j=1; j<=cnt; j++)
                {
                    dp[value*j] = true;
                }
            }
            if(total % 2 == 1) {
                System.out.println(0);
                continue;
            }else if(dp[total / 2]) {
                System.out.println(1);
                continue;
            }
            dp[0] = true;
            for(int i = 1; i <= N; i++) {
                int v = coins[i].value;
                int q = coins[i].cnt;

                for(int j = total/2; j >= v; j--) {
                    if(dp[j - v]) {
                        for(int k = 1; k <= q; k++) {
                            if(j - v + v * k > total/2) break;
                            dp[j - v + v * k] = true;
                        }
                    }
                }
            }
            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }
}
