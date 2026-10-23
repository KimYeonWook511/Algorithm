import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            int p = progresses[i];
            int s = speeds[i];
            
            int val = (100 - p + s - 1) / s;
            
            deque.push(val);
        }
        
        List<Integer> results = new ArrayList<>();
        while (!deque.isEmpty()) {
            int val = deque.pop();
            int cnt = 1;
            
            while (!deque.isEmpty()) {
                if (deque.peek() > val) break;
                
                deque.pop();
                cnt++;
            }
            
            results.add(cnt);
        }
        
        int answer[] = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        
        return answer;
    }
}