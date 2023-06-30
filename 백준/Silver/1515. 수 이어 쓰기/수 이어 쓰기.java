import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int pt = 0;

        int N = 0;
        while (N++ <= 30000) {
            String tmp = String.valueOf(N);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(pt))
                    pt++;
                if (pt == str.length()) {
                    System.out.println(N);
                    return;
                }
            }
        }
    }
}
