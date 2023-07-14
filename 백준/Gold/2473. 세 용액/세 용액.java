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
        long[] arr = new long[N];
        int temp=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long[] res = new long[3];
        long diff = Long.MAX_VALUE;
        for(int i=0; i<N; i++)
        {
            int left = i+1;
            int right = N-1;

            while(left < right)
            {
                long sum = arr[i] + arr[left] + arr[right];
                long cur_diff = Math.abs(sum);
                if(cur_diff < diff)
                {
                    diff = cur_diff;
                    res[0] = arr[i];
                    res[1] = arr[left];
                    res[2] = arr[right];
                }
                if(sum > 0) right--;
                else left++;
            }
        }
        System.out.println(res[0]+" "+res[1]+" "+res[2]);
    }
}
