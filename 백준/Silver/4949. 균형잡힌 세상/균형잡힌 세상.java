import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A: while(true)
        {
            String str = br.readLine();
            if(str.equals("."))
            {
                break;
            }
            char[] arr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<arr.length;i++)
            {
                if(arr[i] == '(' || arr[i] == '[')
                {
                    stack.push(arr[i]);
                }
                if(arr[i] == ')')
                {
                    if(stack.isEmpty() || stack.peek()!='(')
                    {
                        System.out.println("no");
                        continue A;
                    }
                    stack.pop();
                }
                else if(arr[i] == ']')
                {
                    if(stack.isEmpty() || stack.peek()!='[')
                    {
                        System.out.println("no");
                        continue A;
                    }
                    stack.pop();
                }

            }
            System.out.println(stack.isEmpty()?"yes":"no");
        }



    }
}
