
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int P;
    static int X;
    static int [][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    static long cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] x_digit = num_to_digit(X);
        check(0,x_digit);
        System.out.println(cnt);
    }

    public static void check(int num, int[] x_digit)
    {
        for(int i=1; i<= N; i++)
        {
            if(i == X) continue;
            if(can_reverse(i,x_digit)) cnt++;
        }
    }
    public static boolean can_reverse(int target, int[] x_digit)
    {
        int[] target_digit = num_to_digit(target);

        int diff_cnt=0;
        for(int i=0; i<K; i++)
        {
            for(int j=0; j<7; j++)
            {
                if(display[x_digit[i]][j] != display[target_digit[i]][j])
                {
                    diff_cnt++;
                    if(diff_cnt > P) return false;
                }
            }
        }
        return true;
    }
    public static int[] num_to_digit(int x)
    {
        int[] result = new int[K];
        for(int i=K-1; i >= 0; i--)
        {
            result[i] = x%10;
            x /= 10;
        }
        return result;
    }
}
