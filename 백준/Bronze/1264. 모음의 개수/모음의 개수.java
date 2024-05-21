import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String str = br.readLine();
            str = str.toLowerCase();
            if(str.equals("#")) break;
            int cnt=0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i)=='a') cnt++;
                else if(str.charAt(i)=='e') cnt++;
                else if(str.charAt(i)=='i') cnt++;
                else if(str.charAt(i)=='o') cnt++;
                else if(str.charAt(i)=='u') cnt++;
            }
            System.out.println(cnt);
        }
    }
}
