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
        int[] arr = new int[N];
        Arrays.fill(arr,Integer.MIN_VALUE);
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
        {
            int cnt=0;
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++)
            {
                if(cnt==num&&arr[j]==Integer.MIN_VALUE) {
                    arr[j] = i+1;
                    break;
                }
                if(arr[j]==Integer.MIN_VALUE)
                    cnt++;
            }
        }
        for(int i=0; i<N; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
