import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 맵의 크기 N
     * 경사로의 길이 L
     * 2차원 배열 맵 map
     */
    static int N;
    static int L;
    static int result;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        /**
         * 입력 받으면서 가로로 체크할 수 있음
         * 첫번째 값을 저장할 first
         * 두번째 값을 저장할 second
         * 같은 숫자가 반복된 수를 체크할 count
         * 결과값을 저장할 result
         * second 값이 바뀌었음을 체크하는 changeCheck
         */

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++)
        {
            if(checkRow(i)) result++;
            if(checkCol(i)) result++;
        }
        System.out.println(result);
    }

    public static boolean checkRow(int row)
    {
        boolean[] visited = new boolean[N];
        for(int i=0; i<N-1; i++)
        {
            int diff = map[row][i] - map[row][i+1];
            if(diff > 1 || diff < -1) return false;
            // 다음 계단이 한 칸 높다면,
            else if(diff == -1)
            {
                for(int j=0; j<L; j++)
                {
                    /**
                     * i = 현재위치.
                     * i - j = 탐색하는 위치
                     * i-j < 0 : 현재 위치에서 왼쪽으로 계속 가다 0보다 작아질 때,
                     * visited[i-j] : 만약 탐색하는 위치가 방문이 되어 있다면.
                     * map[row][i] != map[row][i-j] : 탐색중인데 L만큼 못채우고 높이가 변한다면.
                     */
                    if(i-j < 0 || visited[i-j]) return false;
                    if(map[row][i] != map[row][i-j]) return false;
                    visited[i-j] = true;
                }
            }
            // 다음 계단이 한 칸 낮다면
            else if(diff == 1)
            {
                /**
                 * 다음 부터 봐야하기 때문에 +1부터 L만큼 횟수를 진행해야 함.
                 */
                for(int j=1; j <= L; j++)
                {
                    /**
                     * i : 현재 위치
                     * i + j : 탐색할 위치
                     * visited[i+j] : 탐색할 곳에 경사로가 놔져 있는지 검사
                     */
                    if( N <= i+j || visited[i+j]) return false;
                    if(map[row][i] -1 != map[row][i+j]) return false;
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }
    public static boolean checkCol(int col)
    {
        boolean[] visited = new boolean[N];
        for(int i=0; i<N-1; i++)
        {
            int diff = map[i][col] - map[i+1][col];
            if(diff > 1 || diff < -1) return false;
            else if(diff == -1)
            {
                for(int j=0; j<L; j++)
                {
                    if(i-j < 0 || visited[i-j]) return false;
                    if(map[i][col] != map[i-j][col]) return false;
                    visited[i-j] = true;
                }
            }
            else if(diff == 1)
            {
                for(int j=1; j<=L; j++)
                {
                    if(N<=i+j || visited[i+j]) return false;
                    if(map[i][col] -1 != map[i+j][col]) return false;
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }
}