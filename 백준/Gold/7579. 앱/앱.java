import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int mArr[] = new int[n + 1];
		int cArr[] = new int[n + 1];
		int dp[][] = new int[10001][n + 1]; // 100을 100번 더한 값 -> r : 0 ~ 10000
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 0; r <= 10001; r++) {
			for (int c = 1; c <= n; c++) {
				if (cArr[c] <= r) dp[r][c] = Math.max(dp[r][c - 1], dp[r - cArr[c]][c - 1] + mArr[c]);
				else dp[r][c] = dp[r][c - 1];
			}
			
			if (dp[r][n] >= m) {
				bw.write(Integer.toString(r));
				break;
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}