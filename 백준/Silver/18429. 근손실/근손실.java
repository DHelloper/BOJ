import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(cnt);
    }

    public static void perm(int index)
    {
        if (index == N) {
            int weight = 500;
            for(int i=0; i<N; i++)
            {
                weight += result[i]-K;
                if(weight<500)
                {
                    return;
                }
            }
            cnt++;
            return;
        }
        // 순열
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result[index] = arr[i];
                visited[i] = true;
                perm(index+1);
                visited[i] = false;
            }
        }
    }
}
