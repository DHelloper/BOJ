
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      int T = Integer.parseInt(st.nextToken());
      for(int t=1; t<=T; t++) {
         int N = Integer.parseInt(br.readLine());
         PriorityQueue<Integer> pq1 = new PriorityQueue<>();
         PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
         Map<Integer, Integer> map = new HashMap<>();
         int insert=0;
         int delete=0;
         int cnt=0;
         for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());
            
            if(command=='I') {
               pq1.add(number);
               pq2.add(number);
               cnt++;
               if(map.containsKey(number)) {
                  map.replace(number, map.get(number)+1);
               }else {
                  map.put(number, 1);
               }
               insert++;
               
            }else if(command=='D') {

               if (cnt == 0) continue;
               
               if(number==-1) {
                  while(!map.containsKey(pq1.peek()) && !pq1.isEmpty()) {
//                     System.out.println("hello");
                     pq1.poll();
                  }
                  
                  if(pq1.isEmpty()) continue;

                  if(map.get(pq1.peek())>1) map.replace(pq1.peek(), map.get(pq1.peek())-1);
                  else map.remove(pq1.poll());
                  
//                  if(!pq1.isEmpty()) {
//                     delete++;
//                  }
               }else if(number==1) {
                  
                  while(!map.containsKey(pq2.peek()) && !pq2.isEmpty()) {
//                     System.out.println("bye");
                     pq2.poll();
                  }
                  if(pq2.isEmpty()) continue;
                  if(map.get(pq2.peek())>1) map.replace(pq2.peek(), map.get(pq2.peek())-1);
                  else map.remove(pq2.poll());
//                  if(!pq2.isEmpty()) {
//                     delete++;
//                  }
               }
               cnt--;
            }
//            System.out.println(pq1.toString());
//            System.out.println(pq2.toString());
//            System.out.println(map.toString());
//            System.out.println(pq1);
         }
//         System.out.println(pq1);
         if(cnt<=0) {
            System.out.println("EMPTY");
//            sb.append("EMPTY").append("\n");
         }
         else {
//            System.out.println(pq1);
        	 while(!map.containsKey(pq2.peek())){
        		 pq2.poll();
        	 }
        	 while(!map.containsKey(pq1.peek())) {
        		 pq1.poll();
        	 }
            System.out.println(pq2.peek()+" "+pq1.peek());
//            sb.append(pq2.peek()).append(" ").append(pq1.peek()).append("\n");
         }
      }
//      System.out.print(sb);
   }

}