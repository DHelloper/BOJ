
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
	import java.util.HashSet;
	import java.util.StringTokenizer;
	
	
	public class Main {
		static class Node{
			int x,y,empty,friends;
	
			public Node(int x, int y, int empty, int friends) {
				super();
				this.x = x;
				this.y = y;
				this.empty = empty;
				this.friends = friends;
			}
	
			@Override
			public String toString() {
				return "Node [x=" + x + ", y=" + y + ", empty=" + empty + ", friends=" + friends + "]";
			}
			
		}
		
		
		static int N,score;
		static int[][] arr;
		static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
		static boolean[][] visited;
		static HashSet<Integer>[] set;
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			set = new HashSet[(N*N)+1];
			visited = new boolean[N][N];
			for(int i=1; i<=N*N; i++) {
				set[i] = new HashSet<>();
			}
			
			
			for(int i=1; i<=N*N; i++) {
				st = new StringTokenizer(br.readLine());
				int node = Integer.parseInt(st.nextToken());
				for (int j = 0; j < 4; j++) {
					set[node].add(Integer.parseInt(st.nextToken()));
				}
				friend(node);
//				print();
//				System.out.println();
				
//				for (int 아이 = 0; 아이 < N; 아이++) {
//					System.out.println(Arrays.toString(visited[아이]));
//				}
//				System.out.println();
				
			}
			check_score();
			System.out.println(score);
		}
		
		public static void friend(int student) {
			Node temp = new Node(0, 0, 0, 0);
			Node zero = new Node(0, 0, 0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					int fnd=0;
					int blank=0;
					int x = i;
					int y = j;
					for(int dir=0; dir<4; dir++) {
						int nx = x+deltas[dir][0];
						int ny = y+deltas[dir][1];
						if(nx<0||N<=nx || ny<0||N<=ny) continue;
						if(arr[nx][ny]==0) {
							blank++;
						}
						if(set[student].contains(arr[nx][ny])) {
							fnd++;
						}
					}
					if(zero.empty==0 && arr[x][y]==0) {
						zero.x = x;
						zero.y = y;
						zero.empty +=1;
					}
					if(temp.friends<fnd) {
						temp.x = i;
						temp.y = j;
						temp.empty = blank;
						temp.friends = fnd;
					}
					else if(temp.friends==fnd) {
						if(temp.empty<blank) {
							temp.x = i;
							temp.y = j;
							temp.empty = blank;
							temp.friends = fnd;
						}
					}
				}
			}
//			System.out.println(visited[temp.x][temp.y]);
			if(temp.empty==0&&temp.friends==0) {
				arr[zero.x][zero.y] = student;
				visited[zero.x][zero.y] = true;
			}
			else {
				
				arr[temp.x][temp.y] = student;
				visited[temp.x][temp.y]= true; 
			}
		}
		
		public static void check_score(){
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int x = i;
					int y = j;
					int fnd=0;
					for(int dir=0; dir<4; dir++) {
						int nx = x+deltas[dir][0];
						int ny = y+deltas[dir][1];
						if(nx<0||N<=nx || ny<0||N<=ny) continue;
//						System.out.println(arr[i][j]);
						if(set[arr[i][j]].contains(arr[nx][ny])) {
							fnd++;
						}
					}
					if(fnd==0) {
						continue;
					}
					else if(fnd==1) {
						score+=1;
					}
					else if(fnd==2) {
						score+=10;
					}
					else if(fnd==3) {
						score+=100;
					}
					else if(fnd==4) {
						score+=1000;
					}
				}
			}
		}
		public static void print() {
			for(int i=0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
