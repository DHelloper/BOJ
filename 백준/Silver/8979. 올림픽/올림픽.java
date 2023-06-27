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
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][3];
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map,(o1,o2) ->
        {
            if(o1[0]!=o2[0])
            {
                if(o1[1]!=o2[1])
                {
                    return o1[2] - o2[2];
                }
                else {
                    return o1[1]-o2[1];
                }
            }
            else
            {
                return o1[0]-o2[0];
            }
        });
//        System.out.println(Arrays.deepToString(map));
        arr[0]=1;
        for(int i=1; i<N; i++)
        {
            if(map[i-1][0]==map[i][0] && map[i-1][1]==map[i][1] && map[i-1][2]==map[i][2])
            {
                arr[i] = arr[i-1];
            }
            else
            {
                arr[i] = i+1;
            }
        }
        System.out.println(arr[K-1]);
    }
}
