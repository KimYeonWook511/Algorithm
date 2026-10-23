import java.util.*;

class Solution {
    static class Node {
        int r, c;
        int cnt;
        
        Node (int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        deque.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            
            if (cur.r == n - 1 && cur.c == m - 1) {
                answer = cur.cnt;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if (nr < 0 || nc < 0) continue;
                if (nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                deque.offer(new Node(nr, nc, cur.cnt + 1));
            }
        }
        
        return answer;
    }
}