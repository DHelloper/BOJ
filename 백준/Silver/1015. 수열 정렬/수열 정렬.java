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
        int[][] A = new int[N][2];
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = i;
        }
        Arrays.sort(A, (o1,o2) ->
        {
            return o1[0] - o2[0];
        });
        for(int i=0; i<N; i++)
        {
            int temp = A[i][1];
            B[temp] = i;
        }
        for(int i=0; i<N; i++)
        {
            System.out.print(B[i]+" ");
        }
    }
}
