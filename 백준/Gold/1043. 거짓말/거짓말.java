
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] parents;

    public static int find(int a){
        if(parents[a]==a){
            return a;
        }
        return find(parents[a]);
    }

    public static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(secret.contains(b)){
            int tmp=a;
            a=b;
            b=tmp;
        }
        parents[b]=a;
    }
    public static int N;
    public static int M;
    public static int secretN;
    public static ArrayList<Integer> secret = new ArrayList<>();
    public static int sum=0;

    public static void main(String args[]) throws NumberFormatException, IOException {

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        secretN = Integer.parseInt(st.nextToken());
        if (secretN != 0) {
//            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < secretN; i++) {
                secret.add(Integer.parseInt(st.nextToken()));
            }
        }
        List<Integer>[] list = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[i].add(x);
            for (int j = 1; j < num; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                list[i].add(y);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int num : list[i]) {
                //연쇄해서 부모를 찾아냄
                if (secret.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
