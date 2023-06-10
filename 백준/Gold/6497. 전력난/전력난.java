

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static class Node implements Comparable<Node>{
		int node;
		long weight;
		@Override
		public String toString() {
			return "Node [node=" + node + ", weight=" + weight + "]";
		}
		public Node(int node, long weight) {
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			//return Long.compare(this.weight,  o.weight);
			return this.weight<o.weight?-1:1;
		}
	}
	static int N,M;
	static List<Node>[] list;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>();
			if(N==0 && M==0) break;
			list = new List[N+1];
			boolean[] visited = new boolean[N+1];
			for(int i=0; i<N+1; i++) {
				list[i] = new ArrayList<>();
			}
			long sum1=0;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				long weight = Long.parseLong(st.nextToken());
				
				list[to].add(new Node(from,weight));
				list[from].add(new Node(to,weight));
				sum1+=weight;
			}
			
			long sum = 0;
			pq.add(new Node(1,0));
			while(!pq.isEmpty()) {
				Node temp = pq.poll();
				if(visited[temp.node]) continue;
				int to = temp.node;
				long weight = temp.weight;
				
				visited[to] = true;
				sum+=weight;
				for(Node next : list[to]) {
					if(!visited[next.node]) {
						pq.add(next);
					}
				}
			}
			int cnt=0;
			for(int i=0; i<N+1; i++) {
				if(!visited[i]) cnt++;
			}
			if(cnt>1) {
				System.out.println(-1);
			}
			else {
				System.out.println(sum1-sum);
//			System.out.println(sum);
			}
//			System.out.println(Arrays.toString(visited));
//		System.out.println(sum1);
//		System.out.println(sum);
		}
		}

}
