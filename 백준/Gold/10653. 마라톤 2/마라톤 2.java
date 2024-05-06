import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Point[] points = new Point[N];
        int dp[][] = new int[K+1][N];
        int dis[][] = new int[N][N];

        int[] arr;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            arr = new int[N];
            Arrays.fill(arr,-1);
            dis[i] = arr;
        }

        for(int i=0; i<=K; i++)
        {
            arr = new int[N];
            Arrays.fill(arr,-1);
            dp[i] = arr;
            if(i==0)dp[i][0]=0;
        }

        int min, temp;
        for(int i=1; i<N; i++){
            for(int j=0; j<=K; j++)
            {
                if(i-j>0){
                    min = Integer.MAX_VALUE;
                    for(int k=0;k<=j;k++)
                    {
                        temp = dp[j-k][i-k-1];
                        if(temp==-1) continue;
                        int distance = Math.abs(points[i-k-1].x-points[i].x) + Math.abs(points[i-k-1].y-points[i].y);
                        dis[i-k-1][i] = distance;
                        dis[i][i-k-1] = distance;
                        min = Math.min(min, temp+distance);
                    }
                    dp[j][i] = min;
                }
            }
        }
        int result = dp[0][N-1];
        for(int i=1; i<=K; i++)
        {
            if(dp[i][N-1] < result) result = dp[i][N-1];
        }
        System.out.println(result);



    }
}
