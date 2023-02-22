import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Ball {
        int index;
        int size;
        int color;

        public Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Ball[] balls = new Ball[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i,color,size);
        }
        Arrays.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.size-o2.size;
            }
        });

        int[] result = new int[N];
        int[] colors = new int[N+1];

        int ball_index = 0;
        int sum =0;
        for(int i=0; i<N; i++)
        {
            Ball tempBall = balls[i];
            while(balls[ball_index].size < tempBall.size)
            {
                sum += balls[ball_index].size;
                colors[balls[ball_index].color] += balls[ball_index].size;
                ball_index++;
            }
            result[tempBall.index] = sum - colors[tempBall.color];
        }

        for(int i=0; i<N; i++)
        {
            System.out.println(result[i]);
        }
    }
}
