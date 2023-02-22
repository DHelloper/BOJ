import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int[][] map;
	static int[][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int arr_num = Math.min(N,M) / 2;
		int r=0;
		for(int i=0; i<arr_num; i++) {
			r = R%((N-i*2)* 2 + (M - i *2) *2 -4); 
			for(int t=0; t<r; t++) {
                int num = map[i][i];
                int dir = 0;
                int x = i; 
                int y = i;
                int px, py;
                
                while(dir < 4) {
                    px = x + deltas[dir][0];
                    py = y + deltas[dir][1];
                    
                    if(px < i || px >= N-i || py < i || py >= M-i ) dir++;
                    else {
                        map[x][y] = map[px][py];
                        x = px; y =py;
                    }
                }
                map[i+1][i] = num;
            }
        }
		print();
	}
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
