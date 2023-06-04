import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] visited;
    static int down;
    static int result;
    static Queue<Integer> robot = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N*2];
        visited = new boolean[N];
        down = N*2-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(check() < K)
        {
            result++;
            rotate();
            move();
            addRobot();
        }
        System.out.println(result);
    }

    public static int check()
    {
        int zero=0;
        for(int i=0 ;i<N*2; i++)
        {
            if(arr[i] == 0)
            {
                zero++;
            }
        }
        return zero;
    }

    public static void rotate()
    {
        int temp = arr[N*2-1];
        for(int i=N*2-1; i>0; i--)
        {
            arr[i] = arr[i-1];
        }

        for(int i=visited.length-1; i>0; i--)
        {
            visited[i] = visited[i-1];
        }
        visited[0] = false;
        visited[N-1] = false;
        arr[0] = temp;
    }

    public static void move()
    {
        for(int i=N-1; i>0; i--)
        {
            if(!visited[i] && arr[i] > 0 && visited[i-1])
            {
                visited[i] = true;
                visited[i-1] = false;
                arr[i]--;
            }
        }
    }
    public static void addRobot()
    {
        if(arr[0] > 0)
        {
            visited[0] = true;
            arr[0]--;
        }
    }


}
