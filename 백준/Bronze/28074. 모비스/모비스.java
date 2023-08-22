
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean check = true;
        if(!str.contains("M") || !str.contains("O") || !str.contains("B") || !str.contains("I") || !str.contains("S"))
        {
            check = false;
        }
        if(check)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
