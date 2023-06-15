import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] visited;
    static List<Integer> list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++)
        {
            map[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        for(int i=1; i<=N; i++)
        {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start, int cnt)
    {
        if(visited[map[start]] == false)
        {
            visited[map[start]] = true;
            dfs(map[start], cnt);
            visited[map[start]] = false;
        }
        if(map[start] == cnt)
        {
            list.add(cnt);
        }

    }
}
