import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int R,C,max = 1, cnt=1;
	static char[][] arr;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R+2][C+2];
		for(int i=0; i<R; i++)
		{
			String input = br.readLine();
			for(int j=0; j<C; j++)
			{
				arr[i][j] = input.charAt(j);
			}
		}
		sb.append(arr[0][0]);
		dfs(sb.toString(), 0,0,cnt);
		System.out.println(max);
		
	}
	public static void dfs(String str, int x, int y,int cnt)
	{
		for(int i=0; i<4;i++)
		{
			int r = x+deltas[i][0];
			int c = y+deltas[i][1];
			
			if(0<=r && r<R && 0<=c && c<C && !str.contains(arr[r][c]+""))
			{
				cnt++;
				max = Math.max(max,cnt);
				sb.append(arr[r][c]);
				dfs(sb.toString(),r,c,cnt);
				sb.deleteCharAt(sb.length()-1);
				cnt--;
			}
		}
		return;
	}
}
