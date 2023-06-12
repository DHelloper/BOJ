import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        check(S,T);
        System.out.println(result);
    }

    public static void check(String s, String t)
    {
        if(s.length() == t.length())
        {
            if(s.equals(t))
            {
                result = 1;
                return;
            }
            return;
        }
        int ans = 0 ;
        if (t.charAt(0)=='B')
        {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String str = sb.reverse().toString();
            check(s,str);
        }
        if(t.charAt(t.length()-1) == 'A')
        {
            check(s,t.substring(0,t.length()-1));
        }
        return;
    }
}
