import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] now_arr_1;// 전구를 켜는 경우
    static int[] now_arr_2; // 전구를 켜지 않는 경우
    static int[] expect_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int ans1 = 1;
        int ans2 = 0;
        int INF = 987654321;
        String now = br.readLine();
        String expect = br.readLine();
        now_arr_1 = new int[N];
        now_arr_2 = new int[N];
        expect_arr = new int[N];

        for(int i = 0; i < N; i++) {
            now_arr_1[i] = now.charAt(i)-'0';
            now_arr_2[i] = now.charAt(i)-'0';
            expect_arr[i] = expect.charAt(i)-'0';
        }
        now_arr_1[0] = 1-now_arr_1[0];
        now_arr_1[1] = 1-now_arr_1[1];

        for(int i = 1; i < N; i++) {
            if(now_arr_1[i-1] != expect_arr[i-1]) {
                now_arr_1[i-1] = 1 - now_arr_1[i-1];
                now_arr_1[i] = 1 - now_arr_1[i];
                ans1++;
                if(i != N-1)
                    now_arr_1[i+1] = 1 - now_arr_1[i+1];

            }
            if(now_arr_2[i-1] != expect_arr[i-1]) {
                now_arr_2[i-1] = 1 - now_arr_2[i-1];
                now_arr_2[i] = 1 - now_arr_2[i];
                ans2++;
                if(i != N-1)
                    now_arr_2[i+1] = 1 - now_arr_2[i+1];
            }
        }

        if(now_arr_1[N-1] != expect_arr[N-1]) ans1 = INF;
        if(now_arr_2[N-1] != expect_arr[N-1]) ans2 = INF;


        if(ans1 == INF && ans2 == INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(ans1, ans2));
    }
}
