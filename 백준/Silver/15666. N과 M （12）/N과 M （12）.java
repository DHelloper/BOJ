import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N,M,cnt;
	static int[] arr;
	static int[] result;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb);
	}
	private static void comb(int cnt,int start)
	{
		if(cnt==M)
		{
			StringBuilder sb2 = new StringBuilder();
			for(int i=0; i<result.length;i++)
			{
				sb2.append(result[i] +" ");
			}
			if(!sb.toString().contains(sb2.toString()))
			{
				sb.append(sb2+"\n");
			}
			return;
		}
		for(int i=start; i<N;i++)
		{
			result[cnt] = arr[i];
			comb(cnt+1,i);
		}
	}
}
