import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int N = a.length();
        int M = b.length();
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[N][M]);
        if(dp[N][M]!=0)
        {
            Stack<Character> stack = new Stack<>();
            while(N>0 && M>0)
            {
                if(N==0 || M == 0) break;
                if(dp[N][M] == dp[N-1][M]) {
                    N--;
                }else if(dp[N][M] == dp[N][M-1]) {
                    M--;
                }else {
                    stack.push(a.charAt(N-1));
                    N--;
                    M--;
                }
            }
            String answer = "";
            while(!stack.isEmpty())
            {
                answer += stack.pop();
            }
            System.out.println(answer);
        }

    }
}
