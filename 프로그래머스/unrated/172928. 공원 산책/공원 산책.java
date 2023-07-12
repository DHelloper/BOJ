import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();
        char[][] map = new char[N][M];
        
        int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
        int startX=0;
        int startY=0;
        for(int i=0; i<map.length; i++)
        {
            map[i] = park[i].toCharArray();
            for(int j=0; j<map[i].length; j++)
            {
                if(map[i][j]=='S')
                {
                    startX=i;
                    startY=j;
                }
            }
            
            // System.out.println(Arrays.toString(map[i]));
        }
        // System.out.println(startX+" "+startY);
        for(int i=0; i<routes.length; i++)
        {
            StringTokenizer st = new StringTokenizer(routes[i]);
            String dirString = st.nextToken();
            int dir=0;
            int move = Integer.parseInt(st.nextToken());
            if(dirString.equals("N")) dir=0;
            else if(dirString.equals("E")) dir=1;
            else if(dirString.equals("S")) dir=2;
            else if(dirString.equals("W")) dir=3;
            int nx = startX;
            int ny = startY;
            boolean check=false;
            for(int j=0; j<move; j++)
            {
                nx += deltas[dir][0];
                ny += deltas[dir][1];
                if(nx<0 || N<=nx || ny<0 || M<=ny || map[nx][ny]=='X') check=true;
            }
            if(!check)
            {
                startX = nx;
                startY = ny;
            }
                
        }
        // System.out.println(startX+" "+startY);
        int[] answer = {startX,startY};
        return answer;
    }
}