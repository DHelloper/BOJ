

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int L;
    static int K;
    static int min = Integer.MIN_VALUE;
    static List<int[]> star = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            star.add(new int[] {x,y});
        }
        for(int[] s1 : star)
        {
            for(int[] s2: star)
            {
                min = Math.max(min, check(s1[0],s2[1]));
            }
        }
        System.out.println(K-min);
    }

    public static int check(int i, int j)
    {
        int res = 0;
        for(int[] s : star)
        {
            if(i <= s[0] &&
                    s[0] <= i+L &&
                    j <= s[1] &&
                    s[1] <= j+L) res++;
        }
        return res;
    }
}
