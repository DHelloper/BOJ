import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String G = st.nextToken();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++)
        {
            String player = br.readLine();
            set.add(player);
        }
        if(G.equals("Y"))
        {
            System.out.println(set.size());
        }
        else if(G.equals("F"))
        {
            System.out.println(set.size()/2);
        }
        else if(G.equals("O"))
        {
            System.out.println(set.size()/3);
        }

    }
}
