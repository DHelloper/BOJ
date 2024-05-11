import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static boolean[] visited;
    static ArrayList<Point> list;
    static boolean out = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[13];
        map = new char[5][9];
        list = new ArrayList<>();
        for(int i=0; i<5; i++)
        {
            String str = br.readLine();
            for(int j=0; j<9; j++)
            {
                map[i][j] = str.charAt(j);
                if(map[i][j] =='x')
                {
                    list.add(new Point(i,j));
                }
                else if(map[i][j]!='.') {
                    visited[map[i][j]-65] = true;
                }
            }
        }
        back(0);
    }

    public static void back(int cnt)
    {
        if(out)
            return;
        if(cnt == list.size()){
            if(check()) {
                for(int i=0; i<5; i++) {
                    for(int j=0; j<9; j++) {
                        System.out.print(map[i][j]+"");
                    }
                    System.out.println();
                }
                out = true;
                return;
            }
            else {
                return ;
            }
        }

        for(int i=0; i<12; i++) {   // A~L 까지 탐색
            if(!visited[i]) {   // 해당 알파벳이 쓰이지 않았다면
                Point temp = list.get(cnt);
                char alpha = (char) (65+i);
                map[temp.x][temp.y]= alpha;
                visited[i] = true;
                back(cnt+1);
                visited[i] = false;
                map[temp.x][temp.y]= '.';
            }
        }
    }

    public static boolean check(){
        int a = (map[0][4]-'A'+1)+(map[1][3]-'A'+1)+(map[2][2]-'A'+1)+(map[3][1]-'A'+1);
        int b = (map[0][4]-'A'+1)+(map[1][5]-'A'+1)+(map[2][6]-'A'+1)+(map[3][7]-'A'+1);
        int c = (map[1][1]-'A'+1)+(map[1][3]-'A'+1)+(map[1][5]-'A'+1)+(map[1][7]-'A'+1);
        int d = (map[3][1]-'A'+1)+(map[3][3]-'A'+1)+(map[3][5]-'A'+1)+(map[3][7]-'A'+1);
        int e = (map[4][4]-'A'+1)+(map[3][3]-'A'+1)+(map[2][2]-'A'+1)+(map[1][1]-'A'+1);
        int f = (map[4][4]-'A'+1)+(map[3][5]-'A'+1)+(map[2][6]-'A'+1)+(map[1][7]-'A'+1);
        if(a==26 && b ==26 && c==26 && d==26 && e==26 && f==26) {
            return true;
        }
        return false;
    }
}
