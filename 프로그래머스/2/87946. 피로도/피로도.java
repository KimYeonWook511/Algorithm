class Solution {
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        func(0, k, 0, dungeons);
        
        return answer;
    }
    
    static void func(int depth, int hp, int visited, int dungeons[][]) {
        answer = Math.max(answer, depth);
        
        if (depth == dungeons.length) return;
        
        for (int i = 0; i < dungeons.length; i++) {
            if ((visited & (1 << i)) > 0) continue;
            if (hp < dungeons[i][0]) continue;
            
            func(depth + 1, hp - dungeons[i][1], visited | (1 << i), dungeons);
        }
    }
}