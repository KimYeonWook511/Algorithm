import java.util.*;

class Solution {
    static class Node {
        int y, x;
        int cnt;
        
        public Node (int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[51 * 2][51 * 2];
        deque.offer(new Node(characterY * 2, characterX * 2, 0));
        visited[characterY * 2][characterX * 2] = true;
        
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            
            if (cur.y == itemY * 2 && cur.x == itemX * 2) {
                answer = cur.cnt / 2;
                break;
            }
                
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || nx < 0) continue;
                if (ny > 101 || nx > 101) continue;

                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;

                // 사각형 내부와 테두리인지 판단
                boolean inFlag = false;
                boolean lineFlag = false;
                for (int i = 0; i < rectangle.length; i++) {
                    int x1 = rectangle[i][0] * 2;
                    int y1 = rectangle[i][1] * 2;
                    int x2 = rectangle[i][2] * 2;
                    int y2 = rectangle[i][3] * 2;
                    if (x1 <= nx && nx <= x2 && y1 <= ny && ny <= y2) {
                        if (x1 < nx && nx < x2 && y1 < ny && ny < y2) {
                            inFlag = true;
                            break;
                        } else {
                            lineFlag = true;
                        }
                    }
                }

                if (lineFlag && !inFlag) {
                    deque.offer(new Node(ny, nx, cur.cnt + 1));
                }
            }
        }
        
        return answer;
    }
}