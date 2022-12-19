
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	/**
	 * 1. 현재 위치 청소
	 * 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색
	 * 		1. 왼쪽 방향에 아직 청소하지 않은 공간이 있다면 그 방향으로 회전한 뒤 한칸 전진 후 1번으로 돌아감
	 * 		2. 왼쪽 방향에 청소할 공간이 없다면 그 방향으로 회전하고 2번으로 돌아감
	 * 		3. 네 방향 모두 청소가 되어 있거나 벽인 경우에는 바라보는 방향을 유지한 채 한칸 후진 후 2번으로 돌아감
	 * 		4. 네 방향 모두 청소가 되어 있거나 벽이면서 뒤도 벽이면 작동 멈춤
	 *
	 * 시작 위치도 청소 하는걸로 침
	 * 방문처리 해놓고 그 부분은 청소하지 않는 걸로 함
	 * @param args
	 */
	
	public static class Robot{
		int r,c;
		int dir;
		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
	
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N,M;
	static int sum;
	static int dir_count;
	static boolean[][] visited;
	static int[][] map;
	static Robot robot;
	static int count = 1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		robot = new Robot(r, c, d);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean();
		System.out.println(sum);
	}
	
	public static void clean() {
		while(true) {
			if(!visited[robot.r][robot.c]) {
//				map[robot.r][robot.c] = count++;
				visited[robot.r][robot.c] = true;				
				sum++;
			}
//			print();
			for(int i=0; i<4; i++) {
				int dir = (robot.dir-1+4)%4;
//				System.out.println(robot.dir);
//				System.out.println(dir);
				int nr = robot.r+deltas[dir][0];
				int nc = robot.c+deltas[dir][1];
				if(map[nr][nc]!=1 && !visited[nr][nc]) {
					robot.r = nr;
					robot.c = nc;
					robot.dir = dir;
					dir_count=0;
					break;
				}
				else {
					dir_count++;
					robot.dir = dir;
				}
			}
//			System.out.println(dir_count);
//			System.out.println(robot.dir);
			if(dir_count==4) {
				dir_count=0;
				int back = (robot.dir-2+4)%4;
//				System.out.println(back);
				int nr = robot.r+deltas[back][0];
				int nc = robot.c+deltas[back][1];
//				System.out.println("r : "+robot.r);
//				System.out.println("c : "+robot.c);
//				System.out.println("nr : "+nr);
//				System.out.println("nc : "+nc);
				if(map[nr][nc]!=1) {
					robot.r = nr;
					robot.c = nc;
//					System.out.println("돌아감");
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+"\t ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
