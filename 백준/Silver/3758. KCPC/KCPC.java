import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class TEAM
    {
        int sum;
        int cnt;
        int[] score;
        int submit;
        int id;

        public TEAM(int sum, int[] score, int cnt, int submit,int id)
        {
            this.sum = sum;
            this.score = score;
            this.cnt = cnt;
            this.submit = submit;
            this.id = id;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최종 점수가 같은 경우, 제출 수가 낮은 팀
        // 둘 다 같은 경우, 마지막 제출이 빠른 팀

        // 클래스로 각 팀을 만들고, 배열에 넣기, 마지막에 정렬
        // 제출 수는 계속 카운트를 늘려가야 함
        // 마지막 제출도 카운트를 늘려가야 함(전체 대상)
        int C = Integer.parseInt(st.nextToken());
        for(int c=0; c<C; c++)
        {
            st = new StringTokenizer(br.readLine());
            // N = 팀의 갯수
            // K = 문제의 갯수
            // t = 내 팀의 ID
            // m = 로그 엔트리 수
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;


            TEAM[] teams = new TEAM[N];
            for(int i=0; i<N; i++)
            {
                teams[i] = new TEAM(0,new int[K],0,0,i+1);
            }
            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken())-1;
                int j = Integer.parseInt(st.nextToken())-1;
                int nowScore = Integer.parseInt(st.nextToken());
                teams[n].score[j] = Math.max(teams[n].score[j],nowScore);
                teams[n].cnt++;
                teams[n].submit = count++;
            }
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<K; j++)
                {
                    teams[i].sum+=teams[i].score[j];
                }
            }
            Arrays.sort(teams, (o1,o2) ->
            {
                if(o1.sum==o2.sum)
                {
                    if(o1.cnt==o2.cnt)
                    {
                        return o1.submit-o2.submit;
                    }
                    return o1.cnt-o2.cnt;
                }
                return o2.sum-o1.sum;
            });
            for(int i=0; i<N; i++)
            {
                if(teams[i].id==T)
                {
                    System.out.println(i+1);
                }
                //System.out.println(teams[i].id+" "+teams[i].sum+" "+teams[i].cnt+" "+teams[i].submit);
            }
        }
    }
}
