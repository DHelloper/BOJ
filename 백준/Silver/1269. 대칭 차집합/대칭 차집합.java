import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<A; i++)
        {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<B; j++)
        {
            setB.add(Integer.parseInt(st.nextToken()));
        }
        int cnt=0;
        for(Integer a : setA)
        {
            if(!setB.contains(a))
            {
                cnt++;
            }
        }
        for(Integer a : setB)
        {
            if(!setA.contains(a))
            {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
