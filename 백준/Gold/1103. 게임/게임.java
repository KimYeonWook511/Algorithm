import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	static int N, M;
	static int arr[][];
	static int dp[][];
	static int result = 0; 
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        dp = new int[N][M];
        
        for (int r = 0; r < N; r++) {
        	String line = br.readLine();
        	
        	for (int c = 0; c < M; c++) {
        		dp[r][c] = Integer.MIN_VALUE;
        		
        		char ch = line.charAt(c);
        		
        		if (ch == 'H') arr[r][c] = -1;
        		else arr[r][c] = ch - '0';
        	}
        }
        
        func(0, 0);
        
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        
        br.close();
    }
    
    static int func(int r, int c) {
    	if (result == Integer.MAX_VALUE) return 0;
    	
    	if (dp[r][c] == -1) {
    		result = Integer.MAX_VALUE;
    		return 0;
    	}
    	
    	if (dp[r][c] != Integer.MIN_VALUE) return dp[r][c];
    	
    	dp[r][c] = -1;
    	
    	int val = 1;
    	int nr, nc;
    	for (int d = 0; d < 4; d++) {
    		nr = r + (dr[d] * arr[r][c]);
    		nc = c + (dc[d] * arr[r][c]);
    		
    		if (nr < 0 || nc < 0) continue;
    		if (nr >= N || nc >= M) continue;
    		if (arr[nr][nc] == -1) continue;
    		
    		val = Math.max(val, func(nr ,nc) + 1);
    	}
    	
    	result = Math.max(result, val);
    	
    	return dp[r][c] = val;
    }
}