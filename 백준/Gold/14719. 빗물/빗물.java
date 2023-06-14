import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] deltas = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt=0;
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            int height = Integer.parseInt(st.nextToken());
            for(int j=0; j<height; j++)
            {
                map[N-1-j][i] = 1;
            }
        }
//        for(int i=0; i<N; i++)
//        {
//            for(int j=0; j<M; j++)
//            {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        // 물이 고일 수 있는 높이를 구해야 함
        // 물이 담길 수 있는 칸들을 구해야 함
        // 아래에서부터 각 칸마다 왼쪽 오른쪽을 탐색하면 될듯?
        for(int i=N-1; i>=0; i--)
        {
            for(int j=0; j<M; j++)
            {
                //만약, 빈공간이라면 ?, 즉 벽이 아니라면
                if(map[i][j] == 0)
                {
                    int left_nr = j+deltas[0];
                    boolean left_wall = false;
                    while(true)
                    {
                        if(left_nr < 0)
                            break;
                        if(map[i][left_nr] == 1)
                        {
                            left_wall = true;
//                            System.out.println("왼쪽 벽 있음");
                            break;
                        }
                        left_nr = left_nr+deltas[0];
                    }
                    int right_nr = j+deltas[1];
                    boolean right_wall = false;
                    while(true)
                    {
                        if(right_nr > M-1)
                            break;
                        if(map[i][right_nr] == 1)
                        {
//                            System.out.println("오른쪽 벽 있음");
                            right_wall = true;
                            break;
                        }
                        right_nr = right_nr+deltas[1];
                    }
                    if(left_wall && right_wall)
                    {
                        cnt++;
                    }

                }
//                System.out.println(i+" "+j+"---------------------------");
            }
        }
        System.out.println(cnt);
    }
}
