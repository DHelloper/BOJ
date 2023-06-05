import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        // 흰색 킹 퀸 룩 비숍 나이트 폰의 개수
        for(int i = 0; i<6; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0)
            {
                sb.append(1-arr[i]+" ");
            }
            else if(i==1)
            {
                sb.append(1-arr[i]+" ");
            }
            else if(i==2)
            {
                sb.append(2-arr[i]+" ");
            }
            else if(i==3)
            {
                sb.append(2-arr[i]+" ");
            }else if(i==4)
            {
                sb.append(2-arr[i]+" ");
            }else if(i==5)
            {
                sb.append(8-arr[i]+" ");
            }
        }
        System.out.println(sb.toString());


    }
}
