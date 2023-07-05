import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            map.put(str,str);
        }
        for(int i=0; i<M; i++)
        {
            String str = br.readLine();
            if(map.containsKey(str))
            {
                list.add(str);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}
