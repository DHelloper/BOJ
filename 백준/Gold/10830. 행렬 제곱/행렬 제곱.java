import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] result;
    static long B;
    static int MOD = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        map = new int[N][N];
        int[][] newMap = new int [N][N];
        result = new int[N][N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                newMap[i][j] = Integer.parseInt(st.nextToken());
                newMap[i][j] %= MOD;
            }
        }
        map = newMap;
        result = pow(B);
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(long b)
    {
        if(b==1)
        {
            return map;
        }
        int[][] tmp = pow(b/2);
        int[][] tmpPow2 = multi(tmp,tmp);
        return b%2==0 ? tmpPow2:multi(tmpPow2,pow(1));
    }

    public static int[][] multi(int[][] a, int[][] b)
    {
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                for(int k=0; k<N; k++)
                {
                    arr[i][j] += a[i][k]*b[k][j];
                }
                arr[i][j] %= MOD;
            }
        }
        return arr;
    }
}
