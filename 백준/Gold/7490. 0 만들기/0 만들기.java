import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            dfs(1,1,0,1,"1");
            System.out.println(sb);
        }
    }

    public static void dfs(int cnt, int num, int sum, int op, String str)
    {
        if(cnt == N)
        {
            sum += (num*op);
            if(sum == 0)
                sb.append(str + "\n");
            return;
        }
        dfs(cnt+1, num*10+(cnt+1), sum, op, str+" "+Integer.toString(cnt+1));
        dfs(cnt+1, cnt+1, sum+(num*op), 1, str+"+"+Integer.toString(cnt+1));
        dfs(cnt+1, cnt+1, sum+(num*op), -1, str+"-"+Integer.toString(cnt+1));
    }
}
