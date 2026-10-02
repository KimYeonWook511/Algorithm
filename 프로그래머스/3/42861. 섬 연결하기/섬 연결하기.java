import java.util.*;

class Solution {
    static int parents[];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        int cnt = n - 1;
        for (int i = 0; i < costs.length; i++) {        
            if (!union(costs[i][0], costs[i][1])) continue;

            answer += costs[i][2];
            if (--cnt == 0) break;
        }
        
        return answer;
    }
    
    static int find(int x) {
        if (parents[x] == x) return x;
        
        return parents[x] = find(parents[x]);
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return false;
        
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
        return true;
    }
}