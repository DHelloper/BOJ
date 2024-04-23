import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int[] arr = new int[1003];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[index] = value;
            if(max < arr[index])
            {
                maxIndex = index;
                max = value;
            }
        }

        int sum = max;
        int leftMax = 0;
        for(int i=0; i<maxIndex;i++)
        {
            if(leftMax<arr[i])
            {
                leftMax = arr[i];
                sum+=leftMax;
            }
            else
                sum+=leftMax;
        }
        int rightMax = 0;
        for(int i=1001; i>maxIndex;i--)
        {
            if(rightMax<arr[i])
            {
                rightMax = arr[i];
                sum+=rightMax;
            }
            else
                sum+=rightMax;
        }
        System.out.println(sum);
    }
}
