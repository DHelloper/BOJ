import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] primes = new boolean[1000001];
    static int N;
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        if(N<8)
        {
            System.out.println(-1);
            return;
        }
        prime();
        list.add(2);
        if(N%2 == 0)
        {
            list.add(2);
            getGoldBach(N-4);
        }
        else
        {
            list.add(3);
            getGoldBach(N-5);
        }
        for(int i=0; i<4; i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }

    public static void prime(){
        primes[0] = primes[1] = true;

        for(int i=2; i*i <= 1000000; i++){
            if(!primes[i])
            {
                for(int j=i*i; j <= 1000000; j+=i)
                {
                    primes[j] = true;
                }
            }
        }

    }

    public static void getGoldBach(int remain){
        for(int i=2; i<= remain/2; i++)
        {
            if(!primes[i] && !primes[remain-i]){
                list.add(i);
                list.add(remain-i);
                break;
            }
        }
    }
}
