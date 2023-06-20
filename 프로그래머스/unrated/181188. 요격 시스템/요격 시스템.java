import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2) -> 
                    {
                       return o1[1]-o2[1];
                    });
        int end = targets[0][1];
        answer++;
        for(int[] target : targets)
        {
            if(target[0] >= end)
            {
                end = target[1];
                answer++;
            }
        }
        // for(int i=0; i<targets.length; i++)
        // {
        //     for(int j=0; j<2; j++)
        //     {
        //         System.out.print(targets[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}