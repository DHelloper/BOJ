import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static class Node{
		int to;
		int dis;
		public Node(int to, int dis) {
			super();
			this.to = to;
			this.dis = dis;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", dis=" + dis + "]";
		}
	}
	static int N,first_max,first_node;
	static List<Node>[] list;
	static boolean[] visited; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new List[N+1];
		visited = new boolean[N+1];
		first_max=Integer.MIN_VALUE;
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to==-1) break;
				int weight = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to, weight));
				list[to].add(new Node(from, weight));
			}
		}
//		System.out.println(list[1].get(0).to);
		visited[1]=true;
		DFS(1,0);
//		first_max=0;
		visited = new boolean[N+1];
//		System.out.println("---------------");
//		System.out.println(first_node);
		visited[first_node]=true;
		DFS(first_node,0);
		System.out.println(first_max);
		
	}
	
	public static void DFS(int start,int sum) {
//		System.out.println("현재 노드 : "+start+" 더한 값 :"+sum);
		if(first_max < sum) {
			first_max = sum;
			first_node = start;
		}
		first_max = Math.max(first_max, sum);
		for(int i=0; i<list[start].size(); i++) {
			if(!visited[list[start].get(i).to]) {
				visited[list[start].get(i).to] = true;
				DFS(list[start].get(i).to, sum+list[start].get(i).dis);
//				visited[list[start].get(i).to] = false;
			}
		}
	}
}
