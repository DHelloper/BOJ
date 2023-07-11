import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0 ;i<str.length();i++)
        {
            stack.push(str.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("P"))
            {
                stack.add(st.nextToken().charAt(0));
            }
            else if(command.equals("L"))
            {
                if(!stack.isEmpty())
                {
                    stack2.add(stack.pop());
                }
            }
            else if(command.equals("D"))
            {
                if(!stack2.isEmpty())
                {
                    stack.push(stack2.pop());
                }
            }
            else if(command.equals("B"))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
        }
        while(!stack2.isEmpty())
            stack.push(stack2.pop());

        StringBuilder sb = new StringBuilder();
        for(Character c : stack)
        {
            sb.append(c);
        }
        System.out.println(sb.toString());

    }
}
