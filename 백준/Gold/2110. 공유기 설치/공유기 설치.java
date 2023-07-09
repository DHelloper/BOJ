import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int low = 1; // 최소 가리가 가질 수 있는 최솟값
        int high = arr[N-1] - arr[0] + 1; // 최소 거리가 가질 수 있는 최댓값
        while(low<high)
        {
            int mid = (low+high)/2;
            if(check(mid)<C)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }

        }
        System.out.println(low-1);
    }
    public static int check(int distance)
    {
        int count = 1;
        int lastLocate = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            int locate = arr[i];
            if(locate - lastLocate >= distance)
            {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
