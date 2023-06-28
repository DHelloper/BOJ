import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //머리를 먼저 찾고. 그 아래가 바로 심장. 그 아래가 바로 허리. 허리에서부터 아래로 대각선 방향 체크
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][N];
        int[] head = new int[2];
        int[] heart = new int[2];
        int[] waist = new int[2];
        int waistLength = 0;
        for(int i=0; i<N; i++)
        {
            char[] temp = br.readLine().toCharArray();
            for(int j=0; j<N; j++)
            {
                map[i][j] = temp[j];
                if(head[0] == 0 && head[1] == 0 && map[i][j]=='*')
                {
                    head[0] = i;
                    head[1] = j;
                }
            }
        }

        heart[0] = head[0]+1;
        heart[1] = head[1];
        int nr = heart[0];
        int nc = heart[1];
        // 허리 체크
        while(true)
        {
            nr+=1;
            if( N <= nr || map[nr][nc]!='*')
            {
                waist[0] = nr;
                waist[1] = nc;
                break;
            }
            waistLength++;
        }
//        waist[0] = heart[0]+1;
//        waist[1] = heart[1];
//        System.out.println(heart[0]);
//        System.out.println(heart[1]);
        nr = heart[0];
        nc = heart[1];
        int leftArm = 0;
        //왼팔 체크
        while(true)
        {
             nc += -1;
             if( nc<0 || map[nr][nc]!='*')
             {
                 break;
             }
             leftArm++;
        }
        //오른팔 체크
        nr = heart[0];
        nc = heart[1];
        int rightArm = 0;
        while(true)
        {
            nc += 1;
            if( N <= nc || map[nr][nc]!='*')
            {
                break;
            }
            rightArm++;
        }
        //왼쪽 다리 체크
        nr = waist[0];
        nc = waist[1]-1;
        int leftLeg = 1;
        while(true)
        {
            nr += 1;
            if(N <= nr || map[nr][nc] !='*')
            {
                break;
            }
            leftLeg++;
        }
        nr = waist[0];
        nc = waist[1]+1;
        int rightLeg = 1;
        while(true)
        {
            nr += 1;
            if(N <= nr || map[nr][nc] !='*')
            {
                break;
            }
            rightLeg++;
        }

        System.out.println((heart[0]+1)+" "+(heart[1]+1));
        System.out.println(leftArm+" "+rightArm+" "+waistLength+" "+leftLeg+" "+rightLeg);

    }
}
