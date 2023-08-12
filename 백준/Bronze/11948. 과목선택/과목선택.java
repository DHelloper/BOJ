import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = new int[4];
        for(int i=0; i<4; i++)
        {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int[] arr2 = new int[2];
        for(int i=0; i<2; i++)
        {
            arr2[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(arr1[3]+arr1[2]+arr1[1]+arr2[1]);

    }
}
