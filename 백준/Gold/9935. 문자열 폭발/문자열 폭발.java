import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String deleteStr = br.readLine();
        int point = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            stack.push(str.charAt(i));
            if(stack.size()>=deleteStr.length())
            {
                boolean check = true;
                for(int j=0; j<deleteStr.length();j++)
                {
                    if(stack.get(stack.size()-deleteStr.length()+j) != deleteStr.charAt(j))
                    {
                        check = false;
                        break;
                    }
                }
                if(check)
                {
                    for(int j=0; j<deleteStr.length();j++)
                    {
                        stack.pop();
                    }
                }
            }
        }
        for (char ch : stack)
            sb.append(ch);

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
