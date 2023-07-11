import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int alength = a.length();
        int blength = b.length();
        char[] A = new char[alength+1];
        char[] B = new char[blength+1];
        int[][] dp = new int[blength+1][alength+1];

        for(int i=1; i<=alength; i++)
        {
            A[i] = a.charAt(i-1);
        }
        for(int i=1; i<=blength; i++)
        {
            B[i] = b.charAt(i-1);
        }
        for(int i=1; i<= blength; i++)
        {
            for(int j=1; j<= alength; j++)
            {
                if(B[i] == A[j])
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[blength][alength]);

    }
}
