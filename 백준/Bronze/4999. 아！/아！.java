
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') {
				cnt++;
			}
		}
		str = br.readLine();
		int cnt2=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') {
				cnt2++;
			}
		}
		System.out.println(cnt<cnt2?"no":"go");
	}

}
