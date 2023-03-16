
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /**
     * 상어를 객체로 만들어서 관리
     * r : 상어의 r 좌표
     * c : 상어의 c 좌표
     * s : 상어의 속도
     * d : 상어가 바라보는 방향
     * z : 상어의 크기
     */
    static public class Shark
    {
        int r;
        int c;
        int s;
        int d;
        int z;
        boolean state;

        public Shark(int r, int c, int s, int d, int z, boolean state) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.state = state;
        }

        @Override
        public java.lang.String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }

    /**
     * 변수 설정
     * R : 격자의 크기 R
     * C : 격자의 크기 C
     * M : 상어의 수 M
     * shark_sum : 낚시꾼이 잡은 상어의 크기
     * map : 현재 상태를 나타낼 2차원 배열
     * deltas : 상어들의 방향을 관리할 2차원 배열
     * shark : 상어들을 관리할 큐
     */
    static int R;
    static int C;
    static int M;
    static int shark_sum;
    static Shark[][] map;
    static int[][] deltas = {{-1,0},{0,-1},{1,0},{0,1}};
    static Queue<Shark> shark_queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 낚시터의 정보 R, C 입력
         * 상어의 마릿수 M 입력
         */
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        /**
         * 상어의 마리수만큼 상어의 정보 입력 받기
         */
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d == 1)
                d = 0;
            else if(d == 4)
                d = 1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z, true);
            shark_queue.add(shark);
            map[r][c] = shark;

        }
        move_man();
        System.out.println(shark_sum);
    }

    /**
     * 낚시꾼이 이동
     */
    public static void move_man()
    {
        /**
         * 한 칸씩 오른쪽으로 이동
         */
        for(int i=0; i<C; i++)
        {
            catch_shark(i);
        }
    }

    /**
     * @param man : 현재 낚시꾼의 위치
     * 가장 가까운 상어 한마리 잡는 로직 수행
     *
     */
    public static void catch_shark(int man)
    {
        for(int i=0; i<R; i++)
        {
            if(map[i][man] != null && map[i][man].state)
            {
//                System.out.println("상어 잡음 크기 : " + map[i][man].z);
                shark_sum += map[i][man].z;
                map[i][man].state = false;
                map[i][man] = null;
                break;
            }
        }
//        System.out.println("상어 잡기 끝");
        move_shark();
    }

    /**
     * 상어를 움직여야 함
     * 방향에 맞게 이동시키고 벽에 닿았을 때 전환해야 함
     * 이동 칸을 나누기 연산으로 최소화 해야함 . (R-1)*2 % s 하면 이동 횟수가 나옴. 그 만큼만 반복하면 됨. 다음 갈 곳을 바라보는 식으로 구현
     * 상어가 이동하면 해당 칸에 상어가 있는지 검사하고 있으면 누가 큰지 검사해서 잡아먹음
     * 잡아먹기까지 완료 되면 상어를 그 칸에 저장.
     */
    public static void move_shark()
    {
//        map = new Shark[R][C];
        Shark[][] new_map = new Shark[R][C];
//        for(int i=0; i<map.length; i++)
//        {
//            new_map[i] = map[i].clone();
//        }

        int size = shark_queue.size();
        for(int i=0; i<size; i++)
        {
            Shark shark_temp = shark_queue.poll();
            if(!shark_temp.state)
            {
                continue;
            }
            int move_result=0;
            /**
             * 상어가 얼만큼 움직여야 하는지 나누기 연산으로 구함
             */
            if(shark_temp.d == 0 || shark_temp.d == 2)
            {
                move_result =  shark_temp.s % ((R-1)*2);
            }
            else
            {
                move_result =  shark_temp.s % ((C-1)*2);
            }
//            System.out.println(move_result);
            for(int move_cnt=0; move_cnt<move_result; move_cnt++)
            {
                int r = shark_temp.r;
                int c = shark_temp.c;
                int nr = r+deltas[shark_temp.d][0];
                int nc = c+deltas[shark_temp.d][1];

//                System.out.println("원래 방향 r : " + r + "원래 방향 c : "+ c + "이 상어의 속도 : "+shark_temp.s + "상어의 방향 : "+shark_temp.d);

//                System.out.println("바뀐 방향 r : " + nr + "바뀐 방향 c : "+ nc);

                if(nr<0 || R <= nr || nc<0 || C <= nc)
                {
//                    System.out.println("방향 전환해야함");
                    int dir = (shark_temp.d+2)%4;
                    shark_temp.d = dir;
                    nr = r+deltas[shark_temp.d][0];
                    nc = c+deltas[shark_temp.d][1];
//                    System.out.println("방향바뀜");
                }
                shark_temp.r = nr;
                shark_temp.c = nc;
            }
//            System.out.println("최종 위치 R : "+(shark_temp.r+1) +" "+"최종 위치 C : " + (shark_temp.c+1));
            /**
             * 이동이 끝나면 해당 칸에 상어가 있는지 없는지 검사해야 함.
             */

            if(new_map[shark_temp.r][shark_temp.c] != null)
            {
//                System.out.println("여기로는 들어오는것 ?");
//                System.out.println("기존 상어의 크기 : "+new_map[shark_temp.r][shark_temp.c].s);
//                System.out.println("현재 상어의 크기 : "+shark_temp.s);
                if(new_map[shark_temp.r][shark_temp.c].z < shark_temp.z)
                {
                    new_map[shark_temp.r][shark_temp.c].state = false;
                    new_map[shark_temp.r][shark_temp.c] = shark_temp;
                    shark_queue.add(shark_temp);
                }
            }
            else {
//                System.out.println(new_map[shark_temp.r][shark_temp.c]);
                new_map[shark_temp.r][shark_temp.c] = shark_temp;
                shark_queue.add(shark_temp);
            }
//            System.out.println("상어 이동 끝,");
        }
//        System.out.println("루틴 한번 끝");
        for(int i=0; i<R; i++)
        {
            map[i] = new_map[i].clone();
        }
    }
}