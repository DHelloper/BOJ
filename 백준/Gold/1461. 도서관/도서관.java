import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static List<Integer> plusList, minusList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        plusList = new ArrayList<>();
        minusList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");

        int max = -1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(x));
            if (x > 0) {
                plusList.add(x);
            } else {
                minusList.add(x);
            }
        }

        Collections.sort(minusList);
        Collections.sort(plusList, Collections.reverseOrder());

        for (int i = 0; i < minusList.size(); i+=M) {
            int first = minusList.get(i);
            if (Math.abs(first) == max) {
                answer += Math.abs(first);
            } else {
                answer += Math.abs(first) * 2;
            }
        }

        for (int i = 0; i < plusList.size(); i+=M) {
            int first = plusList.get(i);
            if (Math.abs(first) == max) {
                answer += Math.abs(first);
            } else {
                answer += Math.abs(first) * 2;
            }
        }

        System.out.println(answer);
    }
}

