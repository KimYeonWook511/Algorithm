import java.util.*;

class Solution {
    static boolean visited[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            answer++;
            visited[i] = true;
            dfs(i, n, computers);
        }
        
        return answer;
    }
    
    static void dfs(int i, int n, int computers[][]) {
        for (int next = 0; next < n; next++) {
            if (visited[next]) continue;
            if (computers[i][next] == 0) continue;
            
            visited[next] = true;
            dfs(next, n, computers);
        }
    }
}