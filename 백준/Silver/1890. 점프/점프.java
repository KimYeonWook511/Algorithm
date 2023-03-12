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

		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 10][n + 10];
		long dp[][] = new long[n + 10][n + 10];
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = 1;
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				int move = arr[r][c];
				
				if (move != 0) {
					dp[r][c + move] += dp[r][c];
					dp[r + move][c] += dp[r][c];
				}
			}
		}
		
		bw.write(Long.toString(dp[n][n]));
		bw.flush();

		br.close();
		bw.close();
	}
}