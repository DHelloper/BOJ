import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String str = br.readLine();
            if(str.equals("end"))
                break;
            map = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;
            int index = 0;

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    map[i][j] = str.charAt(index++);
                    if(map[i][j]=='X')
                        xCnt++;
                    else if(map[i][j] =='O')
                        oCnt++;
                }
            }

            // X가 이긴 경우
            if(xCnt == oCnt+1){
                // 판이 가득차고 O가 완성되지 않은 경우
                if(xCnt+oCnt == 9 && !bingo('O'))
                    System.out.println("valid");
                // O가 완성 되지 않고, X가 완성 된 경우
                else if(!bingo('O') && bingo('X'))
                    System.out.println("valid");
                // 둘 다 아닌 경우는 X도 이기지 못함
                else
                    System.out.println("invalid");
            }
            // O가 이긴 경우
            else if(xCnt == oCnt)
            {
                // X가 완성되지 않고, O가 완성된 경우
                if(!bingo('X') && bingo('O'))
                    System.out.println("valid");
                // 그게 아니라면 먼저 두는 것은 X이기 때문에 이길 수 없음
                else
                    System.out.println("invalid");
            }
            // 둘 다 완성되지 않은 경우
            else
                System.out.println("invalid");
        }
    }
    public static boolean bingo(char c)
    {
        for(int i=0; i<3; i++)
        {
            // 가로 한줄로 성공한 경우
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c)
                return true;
        }
        for(int i=0; i<3; i++)
        {
            // 세로 한줄로 성공한 경우
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c)
                return true;
        }
        // 대각선으로 성공한 경우, 좌상에서 우하로
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c)
            return true;
        // 대각선으로 성공한 경우, 우상에서 좌하로
        if(map[0][2] == c && map[1][1] == c && map[2][0] == c)
            return true;
        // 여기까지 return이 없을 경우 끝나지 않음
        return false;
    }
}