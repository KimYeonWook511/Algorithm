import java.util.*;

class Solution {
    static class Node {
        int i;
        int v;
        
        Node (int i, int v) {
            this.i = i;
            this.v = v;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        List<Node> graph[] = new ArrayList[N + 1];
        int dist[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int v = road[i][2];
            
            graph[a].add(new Node(b, v));
            graph[b].add(new Node(a, v));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.v, o2.v);
            }
        });
        boolean chk[] = new boolean[N + 1];
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
        int answer = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (chk[cur.i]) continue;
            chk[cur.i] = true;
            answer++;
            
            for (Node next : graph[cur.i]) {
                if (chk[next.i]) continue;
                if (dist[next.i] <= cur.v + next.v) continue;
                if (cur.v + next.v > K) continue;
                
                dist[next.i] = cur.v + next.v;
                pq.offer(new Node(next.i, cur.v + next.v));
            }
        }
        
        return answer;
    }
}