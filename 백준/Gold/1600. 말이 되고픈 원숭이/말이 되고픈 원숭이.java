import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int K = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int W = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	
    	int d[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}}; // r로 대칭
        int INF = 1_000_000_000;

    	int dp[][][] = new int[H + 4][W + 4][K + 1];

    	for (int r = 2; r < H + 2; r++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for (int c = 2; c < W + 2; c++) {
                dp[r][c][0] = -1;

    			if (st.nextToken().charAt(0) == '1') continue;

                for (int k = 0; k <= K; k++) {
                    dp[r][c][k] = INF;
                }
    		}

    		dp[r][0][0] = dp[r][1][0] = dp[r][W + 2][0] = dp[r][W + 3][0] = -1;
    	}

    	for (int c = 0; c < W + 4; c++) {
    		dp[0][c][0] = dp[1][c][0] = dp[H + 2][c][0] = dp[H + 3][c][0] = -1;
    	}
    	
        dp[2][2][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
    	deque.offer(new int[] {2, 2, 0});

        while (!deque.isEmpty()) {
			int cur[] = deque.poll();
			int r = cur[0];
			int c = cur[1];
            int k = cur[2];
			
            if (r == H + 1 && c == W + 1) {
                dp[r][c][K] = Math.min(dp[r][c][K], dp[r][c][k]);
                continue;
            }

			if (dp[r - 1][c][0] != -1 && dp[r][c][k] + 1 < dp[r - 1][c][k]) {
				dp[r - 1][c][k] = dp[r][c][k] + 1;
				deque.offer(new int[] {r - 1, c, k});
			}
			
			if (dp[r + 1][c][0] != -1 && dp[r][c][k] + 1 < dp[r + 1][c][k]) {
				dp[r + 1][c][k] = dp[r][c][k] + 1;
				deque.offer(new int[] {r + 1, c, k});
			}
			
			if (dp[r][c - 1][0] != -1 && dp[r][c][k] + 1 < dp[r][c - 1][k]) {
				dp[r][c - 1][k] = dp[r][c][k] + 1;
				deque.offer(new int[] {r, c - 1, k});
			}
			
			if (dp[r][c + 1][0] != -1 && dp[r][c][k] + 1 < dp[r][c + 1][k]) {
				dp[r][c + 1][k] = dp[r][c][k] + 1;
				deque.offer(new int[] {r, c + 1, k});
			}

            if (k == K) continue;

            int nc = 0;

            for (int i = 0; i < 4; i++) {
                nc = c + d[i][1];
                
                if (dp[r + d[i][0]][nc][0] != -1 && dp[r][c][k] + 1 < dp[r + d[i][0]][nc][k + 1]) {
                    dp[r + d[i][0]][nc][k + 1] = dp[r][c][k] + 1;
                    deque.offer(new int[]{r + d[i][0], nc, k + 1});
                }
                
                if (dp[r - d[i][0]][nc][0] != -1 && dp[r][c][k] + 1 < dp[r - d[i][0]][nc][k + 1]) {
                    dp[r - d[i][0]][nc][k + 1] = dp[r][c][k] + 1;
                    deque.offer(new int[]{r - d[i][0], nc, k + 1});
                }
            }
    	}
    	
    	System.out.println(dp[H + 1][W + 1][K] == INF ? "-1" : dp[H + 1][W + 1][K]);
    	
        br.close();
    }
}