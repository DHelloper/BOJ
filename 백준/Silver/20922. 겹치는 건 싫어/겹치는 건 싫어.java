import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left =0;
        int right = 0;
        int[] temp = new int[100001];
        while(right < arr.length)
        {
            while(right < arr.length && temp[arr[right]]+1<=K)
            {
                temp[arr[right]]++;
                right++;
            }
            int length = right-left;
            max = Math.max(max,length);
            temp[arr[left]]--;
            left++;
        }
        System.out.println(max);
    }
}
