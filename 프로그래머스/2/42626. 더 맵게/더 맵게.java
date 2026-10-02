import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i] * 1L);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            long val1 = pq.poll();
            long val2 = pq.poll();
            pq.offer(val1 + (val2 * 2));
            answer++;
        }
        
        return answer;
    }
}