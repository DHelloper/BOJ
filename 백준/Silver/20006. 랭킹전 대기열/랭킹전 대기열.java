
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class ROOM {
        List<PLAYER> player = new ArrayList<>();
    }

    public static class PLAYER implements Comparable<PLAYER>{
        int level;
        String name;

        public PLAYER(int level, String name)
        {
            this.level = level;
            this.name = name;
        }


        @Override
        public int compareTo(PLAYER o) {
            return name.compareTo(o.name);
        }
    }

    static List<ROOM> rooms = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=1; i<=p; i++)
        {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean check = false;
            PLAYER player = new PLAYER(level,name);


            for(ROOM room : rooms)
            {
                if(room.player.size() >= m)
                {
                    continue;
                }
                if(!room.player.isEmpty() && room.player.get(0).level - 10 <= level && level <= room.player.get(0).level + 10)
                {
                    check = true;
                    room.player.add(player);
                    break;
                }
            }
            if(!check)
            {
                ROOM room = new ROOM();
                room.player.add(player);
                rooms.add(room);
            }
        }
        for(ROOM room : rooms)
        {
            Collections.sort(room.player);
            if(room.player.size() == m)
            {
                System.out.println("Started!");
            }
            else
            {
                System.out.println("Waiting!");
            }
            for(int i=0; i<room.player.size();i++)
            {
                int level = room.player.get(i).level;
                String name = room.player.get(i).name;

                System.out.println(level+" "+ name);
            }
        }
    }
}
