import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
        // 2. 같은 문자는 같은 갯수만큼 있다.
        // 위 조건을 만족하면 GOOD

        //길이가 같고, 구성까지 같은 경우
        //길이가 짧은 경우(같은 단어의 수 -1 이 참일 경우)
        //길이가 긴 경우(같은 단어의 수 +1이 참일 경우)
        
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        String str = br.readLine();
        for (int i=0; i<N-1; i++)
        {
            String str2 = br.readLine();
            int cnt = 0;
            int[] arr = new int[26];
            for(int j=0; j<str.length();j++)
            {
                arr[str.charAt(j)-'A']++;
            }
            for(int j=0; j<str2.length();j++)
            {
                if(arr[str2.charAt(j)-'A']>0)
                {
                    cnt++;
                    arr[str2.charAt(j)-'A']--;
                }
            }
            if(str.length() == str2.length() && (str.length()==cnt || str.length()-1 == cnt))
            {
                result++;
            }
            else if (str.length() == str2.length() -1 && str2.length()-1 == cnt)
            {
                result++;
            }
            else if (str.length() == str2.length()+1 && str2.length() == cnt)
            {
                result++;
            }
        }
        System.out.println(result);
    }
}
