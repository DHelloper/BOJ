
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int find(int x)
    {
        if(x == parents[x])
        {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y)
    {
        if(x<y)
        {
            parents[find(y)] = parents[find(x)];
        }
        else
        {
            parents[find(x)] = parents[find(y)];
        }

    }
    static int N;
    static int M;

    static int[] parents;
    static List<Integer> parent = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for(int i=0; i<N; i++)
        {
            parents[i] = i;
        }
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(find(start) != find(end))
            {
                union(start,end);
            }
            else
            {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("0");

    }
}
