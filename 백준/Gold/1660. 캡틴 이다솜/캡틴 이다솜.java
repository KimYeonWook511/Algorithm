import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int temp[] = new int[122];
        int dp[] = new int[122];
        temp[1] = dp[1] = 1;
        
        for (int i = 2; i < 122; i++) {
        	temp[i] = temp[i - 1] + i;
        	dp[i] = temp[i] + dp[i - 1];
        }
        
        int cnt[] = new int[N + 1];
        cnt[1] = 1;
        for (int i = 2; i <= N; i++) {
        	cnt[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 2; i <= N; i++) {
        	for (int k = 1; k < 122; k++) {
        		if (dp[k] > i) break;
        		
        		cnt[i] = Math.min(cnt[i], cnt[i - dp[k]] + 1);
        	}
        }
        
        System.out.println(cnt[N]);

		br.close();
	}
}