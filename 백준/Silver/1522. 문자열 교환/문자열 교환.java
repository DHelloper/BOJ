import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int a_cnt = 0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='a')
                a_cnt++;
        }
        for(int i=0; i<str.length();i++)
        {
            int b_cnt=0;
            for(int j=0; j<a_cnt;j++)
            {

                int index = i+j;

                if(index>=str.length()) {
                    index = i + j - str.length();
                }
                if(str.charAt(index)=='b') {
                    b_cnt++;
                }
            }
            result = Math.min(result,b_cnt);
        }
        System.out.println(result);
    }
}
