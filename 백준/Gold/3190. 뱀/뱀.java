

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Main {

	
	static int N,K,L;
	static int[][] map;
	static int[] head = {0,0};
	static int[] tail = {0,0};
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static Deque<int[]> snake = new ArrayDeque<>();
	static int time;
	static int dir;
	static HashMap<Integer, String> rotate = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		snake.offer(new int[] {0,0});
		map[0][0] = 1;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			rotate.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
//		System.out.println(rotate);
//		print();
		while(true) {
			time++;
			int head_nx = snake.getFirst()[0]+deltas[dir][0];
			int head_ny = snake.getFirst()[1]+deltas[dir][1];
			if(head_nx<0||N<=head_nx||head_ny<0||N<=head_ny||map[head_nx][head_ny]==1) break;
			if(map[head_nx][head_ny]==2) {
				map[head_nx][head_ny]=1;
				snake.offerFirst(new int[] {head_nx,head_ny});
				
			}
			else {
				map[head_nx][head_ny]=1;
				snake.offerFirst(new int[] {head_nx,head_ny});
				map[snake.getLast()[0]][snake.getLast()[1]] = 0;
				snake.pollLast();
				
			}
//			print();
			if(rotate.containsKey(time)) {
				if(rotate.get(time).equals("D")) {
					dir++;
					dir = (4+dir)%4;
				}
				else if(rotate.get(time).equals("L")) {
					dir--;
					dir = (4+dir)%4;
				}
			}
//			System.out.println();
		}
		System.out.println(time);
	}

	
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
