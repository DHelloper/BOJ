import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] map = new int[N+1];
        int[] cnt = new int[N+1];
        int[] near = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            map[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=N;i++)
        {
            while(!stack.isEmpty() && map[stack.peek()]<=map[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if(cnt[i]>0) near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i=N; i>0; i--)
        {
            while(!stack.isEmpty() && map[stack.peek()]<=map[i]) {
                stack.pop();
            }
            int s = stack.size();
            cnt[i] += s;
            if(s > 0 && stack.peek()-i < i-near[i]) near[i] = stack.peek();
            stack.push(i);
        }
        for(int i=1; i<=N; i++)
        {
            System.out.println(cnt[i]>0?cnt[i]+" "+near[i]:cnt[i]);
        }
    }
}
