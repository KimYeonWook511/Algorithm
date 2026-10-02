import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // n 1~100
        // results.length 1~4500
        // results[i][0]이 results[i][1]을 이김
        // 모든 경기 결과에는 모순이 없음
        
        List<Integer> winGraph[] = new ArrayList[n + 1];
        List<Integer> loseGraph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            winGraph[win].add(lose);
            loseGraph[lose].add(win);
        }
        
        for (int i = 1; i <= n; i++) {
            int winCnt = bfs(i, winGraph, n);
            int loseCnt = bfs(i, loseGraph, n);
            
            if (winCnt + loseCnt == n - 1) answer++;
        }
        
        return answer;
    }
    
    static int bfs(int start, List<Integer> graph[], int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        deque.offer(start);
        visited[start] = true;
        
        int cnt = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                
                deque.offer(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }
}