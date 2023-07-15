import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        int[] dpIdx = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int LIS = 0;
        Arrays.fill(dp,Integer.MIN_VALUE);
        for(int i=0; i<N; i++)
        {
            int idx = BinarySearch(arr[i], 0, LIS, LIS+1);
            if(idx==-1)
            {
                dp[LIS++] = arr[i];
                dpIdx[i] = LIS-1;
//                System.out.println(arr[i]);
            }
            else
            {
                dp[idx] = arr[i];
                dpIdx[i] = idx;
//                System.out.println(arr[i]);
            }
        }
        System.out.println(LIS);
        List<Integer> list = new ArrayList<>();
        LIS--;
        for(int i=N-1 ;i>=0; i--)
        {
            if(dpIdx[i]==LIS)
            {
                list.add(arr[i]);
                LIS--;
            }
        }
        for(int i=list.size()-1; i>=0; i--)
        {
            System.out.print(list.get(i)+" ");
        }


    }
    public static int BinarySearch(int num, int start, int end, int size)
    {
        int res = 0;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(num <= dp[mid])
            {
                res = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        if(start==size)
        {
            return -1;
        }
        else
            return res;
    }
}
