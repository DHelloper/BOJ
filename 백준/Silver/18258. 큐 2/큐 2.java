import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> que = new LinkedList<>();
		String str;
		int x=0;
		for(int i=0; i<N; i++)
		{
//			st = new StringTokenizer(br.readLine()," ");
			str = br.readLine();
			if(str.contains(" ")) 
			{
				st = new StringTokenizer(str," ");
				str = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				que.add(x);
			}
			if(str.contains("front"))
			{
				if(que.isEmpty()) sb.append(-1+"\n"); // System.out.println(-1);
				else {
					sb.append(que.peekFirst()+"\n");
				}
				
			}
			else if(str.contains("pop")) 
			{
				if(que.isEmpty()) sb.append(-1+"\n"); //System.out.println(-1);
				else {
					sb.append(que.poll()+"\n");
				}
			}
			else if(str.contains("size")) sb.append(que.size()+"\n"); //System.out.println(que.size());
			else if(str.contains("empty")) sb.append((que.isEmpty()?1:0)+"\n"); //System.out.println(que.isEmpty()?1:0);
			else if(str.contains("back")) 
			{
				if(que.isEmpty()) sb.append(-1+"\n"); //System.out.println(-1);
				else {
					sb.append(que.peekLast()+"\n");
				}
			}
		}
		System.out.println(sb);
	}

}
