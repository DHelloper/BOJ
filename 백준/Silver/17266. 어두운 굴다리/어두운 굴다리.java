import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int min = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int low = 1;
        int high = N;
        while(low <= high)
        {
            int mid = (low+high)/2;
            int point = 0;
            boolean flag = true;
            for(int i=0; i<arr.length; i++)
            {
                if(arr[i] - mid <= point)
                {
                    point = arr[i] + mid;
                }
                else
                    flag = false;
            }
            if(N - point > 0 ) flag = false;
//            else flag = true;
            if(flag)
            {
                min = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        System.out.println(min);
    }
}
