import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] arr,result;
	static int L,C;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println((char)58);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine()," ");
//		arr = br.readLine().toCharArray();
		for(int i=0; i<C; i++)
		{
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		comb(0,0);
	}
	public static void comb(int cnt,int start)
	{
		int con=0;
		int vow=0;
		if(cnt==L)
		{
			for(int i=0; i<result.length; i++)
			{
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
				{
					vow++;
				}
				else 
				{
					con++;
				}
			}
			if(1 < con && 0 < vow)
			{
//				System.out.println(result.toString());
				for(int i=0; i<result.length;i++)
				{
					System.out.print(result[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start; i<C; i++)
		{
			result[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
	}

}
