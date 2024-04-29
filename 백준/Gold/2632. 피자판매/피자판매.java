import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int target;
    static int M,N;
    static int[] A,B;
    static int[] arrA,arrB;
    static int[] sumA,sumB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[M*2+1];
        B = new int[N*2+1];
        for(int i=1; i<=M; i++)
        {
            A[i] = Integer.parseInt(br.readLine());
            A[i+M] = A[i];
        }
        for(int i=1; i<=N; i++)
        {
            B[i] = Integer.parseInt(br.readLine());
            B[i+N] = B[i];
        }
        sumA = new int[M*2+1];
        sumB = new int[N*2+1];
        sumA[1] = A[1];
        sumB[1] = B[1];
        for(int i=2; i<=M*2; i++)
        {
            sumA[i] = A[i] + sumA[i-1];
        }for(int i=2; i<=N*2; i++)
        {
            sumB[i] = B[i] + sumB[i-1];
        }

        arrA = new int[target+1];
        arrB = new int[target+1];

        makeArr(arrA, sumA, M);
        makeArr(arrB, sumB, N);

        int answer = 0;
        answer += arrA[target];
        answer += arrB[target];
        for(int i=0; i<target; i++)
        {
            int a = i;
            int b = target-i;
            answer += arrA[a]*arrB[b];
        }
        System.out.println(answer);

    }

    public static void makeArr(int[] arr, int[] sum, int size)
    {
        for (int i = 1; i < size; i++) {
            for (int s = 1; s <= size; s++) { 
                int value = sum[s + i - 1] - sum[s - 1];
                if (value > target) continue; 
                arr[value]++;
            }
        }
        if (sum[size] <= target) arr[sum[size]]++;
    }
}
