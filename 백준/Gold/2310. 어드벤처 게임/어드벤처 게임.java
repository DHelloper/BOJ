import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Room{
        char type;
        int value;
        List<Integer> door;
        boolean visited=false;
        public Room(char type, int value, List<Integer> door,boolean visited)
        {
            this.type = type;
            this.value = value;
            this.door = door;
            this.visited = visited;
        }
    }
    static int N;
    static List<Room> list;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            //맵 정보 받을 준비
            list = new ArrayList<>();
            for(int i=0; i<N; i++)
            {
                result=0;
                List<Integer> roomList = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                char t = st.nextToken().charAt(0);
                int v = Integer.parseInt(st.nextToken());
                while(true)
                {
                    int check = Integer.parseInt(st.nextToken());
                    if(check==0) break;
                    roomList.add(check-1);
                }

                list.add(new Room(t,v,roomList,false));
            }
            DFS(0,0);
            System.out.println(result==1?"Yes":"No");
        }
    }

    public static void DFS(int start, int gold)
    {
        if(list.get(start).type=='T') gold-=list.get(start).value;
        else {
            if(gold < list.get(start).value)
                gold+=list.get(start).value;
        }

        if(gold>=0)
        {
            if(start+1==N){
                result = 1;
                return;
            }
            list.get(start).visited=true;
            for(int i=0; i<list.get(start).door.size();i++)
            {
                if(!list.get(list.get(start).door.get(i)).visited)
                    DFS(list.get(start).door.get(i),gold);
            }
            list.get(start).visited=false;
        }
        else
        {
            if(list.get(start).type=='T') gold += list.get(start).value;
            return;
        }
        /*if(start==N+1) {
            if(gold>0) result = 1;
            return;
        }*/


    }
}
