import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int LIS = 0;
        for(int i=0; i<N; i++)
        {
            int idx = BinarySearch(arr[i], 0, LIS, LIS+1);
            if(idx == -1)
            {
                dp[LIS++] = arr[i];
            }
            else
            {
                dp[idx] = arr[i];
            }
        }
        System.out.println(LIS);
    }
    public static int BinarySearch(int num, int start, int end, int size)
    {
        int res = 0;
        while(start<=end)
        {
            int mid = (start+end) / 2;
            if(num <= dp[mid])
            {
                res = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        if(start == size)
        {
            return -1;
        }
        else
        {
            return res;
        }
    }
}
