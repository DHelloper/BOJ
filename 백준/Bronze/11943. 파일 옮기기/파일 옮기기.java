
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        arr1[0] = Integer.parseInt(st.nextToken());
        arr1[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr2[0] = Integer.parseInt(st.nextToken());
        arr2[1] = Integer.parseInt(st.nextToken());
        int sum1 = arr1[0]+arr2[1];
        int sum2 = arr1[1]+arr2[0];
        System.out.println(Math.min(sum1,sum2));

    }
}
