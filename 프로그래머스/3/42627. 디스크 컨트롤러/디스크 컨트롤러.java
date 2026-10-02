import java.util.*;

class Solution {
    static class Node {
        int i, s, l;
        
        public Node (int i, int s, int l) {
            this.i = i;
            this.s = s;
            this.l = l;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.l != o2.l) return Integer.compare(o1.l, o2.l);
                if (o1.s != o2.s) return Integer.compare(o1.s, o2.s);
                return Integer.compare(o1.i, o2.i);
            }
        });
        
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < jobs.length; i++) {
            int s = jobs[i][0];
            int l = jobs[i][1];
            
            while (!pq.isEmpty() && pre < s) {
                Node cur = pq.poll();
                
                if (cur.s < pre) {
                    sum += pre - cur.s; // 대기 시간
                } else if (cur.s > pre) {
                    pre = cur.s; // 디스크 휴식 시간
                }
                
                sum += cur.l; // 작업 시간
                pre += cur.l; // 끝나는 시간
            }
            
            pq.offer(new Node(i, s, l));
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.s < pre) {
                sum += pre - cur.s; // 대기 시간
            } else if (cur.s > pre) {
                pre = cur.s;
            }
                
            sum += cur.l; // 작업 시간
            pre += cur.l; // 끝나는 시간
        }
        
        answer = sum / jobs.length;
        
        return answer;
    }
}