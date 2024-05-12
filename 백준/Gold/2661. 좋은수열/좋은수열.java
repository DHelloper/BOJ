import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean exit = false;
    static boolean[] number;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = new boolean[4];
        N = Integer.parseInt(br.readLine());
        back(0);

    }
    public static void back(int cnt)
    {
        if(exit) return;
        if(cnt==N){
            System.out.println(answer);
            exit = true;
            return;
        }
        for(int i=1; i<4; i++)
        {
            answer+=i;
                if(check(answer))
                {
                    back(cnt+1);
                }
                answer = answer.substring(0,answer.length()-1);
        }

    }

    public static boolean check(String str) {
        for(int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() -i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}
