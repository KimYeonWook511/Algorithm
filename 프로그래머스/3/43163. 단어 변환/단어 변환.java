import java.util.*;

class Solution {
    static class Node {
        String str;
        int cnt;
        
        public Node (String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[words.length];
        deque.offer(new Node(begin, 0));
        
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            
            if (target.equals(cur.str)) {
                answer = cur.cnt;
                break;
            }
                
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                String word = words[i];
                int count = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (cur.str.charAt(j) != word.charAt(j)) {
                        if (++count >= 2) break;
                    }
                }
                
                if (count == 1) {
                    deque.offer(new Node(word, cur.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return answer;
    }
}