import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,String> numberToName = new HashMap<>();
        HashMap<String,String> nameToNumber = new HashMap<>();

        for(int i=1; i<=N; i++)
        {
            String name = br.readLine();
            numberToName.put(i+"",name);
            nameToNumber.put(name,i+"");
        }
        for(int i=1; i<=M; i++)
        {
            String str = br.readLine();
            if(numberToName.containsKey(str))
            {
                System.out.println(numberToName.get(str));
            }
            else if(nameToNumber.containsKey(str))
            {
                System.out.println(nameToNumber.get(str));
            }
        }
    }
}
