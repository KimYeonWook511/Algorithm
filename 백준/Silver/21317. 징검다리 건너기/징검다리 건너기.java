import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int jump[][] = new int[N + 3][2];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			jump[i][0] = Integer.parseInt(st.nextToken());
			jump[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[N + 3][2];
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < N; i++) {
			// 아직 슈퍼 점프 사용 안 함
			dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + jump[i][0]);
			dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + jump[i][1]); 
			
			// 이미 슈퍼 점프 사용 함
			dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + jump[i][0]);
			dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + jump[i][1]);
			
			// 이번에 슈퍼 점프 사용
			dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + K); 
		}
		
		System.out.println(Math.min(dp[N][0], dp[N][1]));
		
		br.close();
	}
}