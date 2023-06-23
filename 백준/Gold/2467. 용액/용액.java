

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left =0;
        int right =N-1;
        int ml =0, mr = 0;
        long min = Long.MAX_VALUE;
        /**
         * 두 용액의 값을 투 포인터로 찾아서 더해봄 ?
         * 투 포인터.
         * l과 r을 더해보고, 목표 값 0보다 커질때까지 r 증가를 반복, 그리고 0에 가까운지 판단하여 갱신.
         * 0보다 커지면 l을 줄여보면서 0에 가까운지 판단하여 갱신
         */
        while(left<right) {
            long sum = arr[left]+arr[right];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                ml = left; mr = right;
            }
            if(sum>=0) {
                right--;
            }else {
                left++;
            }
        }
        System.out.println(arr[ml] +" "+arr[mr]);
    }
}
