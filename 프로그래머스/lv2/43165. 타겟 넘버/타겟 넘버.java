import java.util.*;

class Solution {
    static int answer;
    static int size;
    static int result_cnt;
    static int target_copy;
    static int[] numbers_copy;
    static int[] result;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        answer = 0;
        numbers_copy = numbers.clone();
        size = numbers_copy.length;
        target_copy = target;
        result = new int[size];
        visited = new boolean[size];
        // System.out.println(Arrays.toString(numbers_copy));
        DFS(0,0);
        return result_cnt;
    }
    public static void DFS(int cnt, int start)
    {
        if(cnt == size)
        {
            // System.out.println(Arrays.toString(result));
            int sum=0;
            for(int i=0; i<size; i++)
            {
                sum += result[i];
            }
            if(sum==target_copy)
            {
                result_cnt++;
            }
            return;
        }
        result[cnt] = numbers_copy[start]*-1;
        DFS(cnt+1,start+1);
        result[cnt] = numbers_copy[start];
        DFS(cnt+1,start+1);
    }
}