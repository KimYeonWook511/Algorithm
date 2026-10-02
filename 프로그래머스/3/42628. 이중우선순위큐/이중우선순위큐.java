import java.util.*;

class Solution {
    static class Node {
        int num;
        boolean isDel;
        
        public Node (int num) {
            this.num = num;
            this.isDel = false;
        }
    }
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Node> minPq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });
        PriorityQueue<Node> maxPq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -Integer.compare(o1.num, o2.num);
            }
        });
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) {
                Node node = new Node(num);
                maxPq.offer(node);
                minPq.offer(node);
            } else {
                func(num == 1 ? maxPq : minPq);
            }
        }
        
        while (!maxPq.isEmpty()) {
            Node cur = maxPq.poll();
            
            if (!cur.isDel) {
                answer[0] = cur.num;
                break;
            }
        }
        while (!minPq.isEmpty()) {
            Node cur = minPq.poll();
            
            if (!cur.isDel) {
                answer[1] = cur.num;
                break;
            }
        }
        
        return answer;
    }
    
    static void func(PriorityQueue<Node> pq) {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.isDel) continue;
            
            cur.isDel = true;
            return;
        }
    }
}