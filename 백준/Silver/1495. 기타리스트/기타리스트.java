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
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n + 1];
		boolean dp[][] = new boolean[n + 1][m + 1];
		int max = -1;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][s] = true;
		
		for (int r = 1; r <= n; r++) {
			for (int c = 0; c <= m; c++) {
				if (dp[r - 1][c]) {
					int plus = c + arr[r];
					int minus = c - arr[r];
					
					if (plus <= m) dp[r][plus] = true;
					if (minus >= 0) dp[r][minus] = true;
				}
			}
		}
		
		for (int c = m; c >= 0; c--) {
			if (dp[n][c]) {
				max = c;
				break;
			}
		}
		
		bw.write(Integer.toString(max));
		bw.flush();
		
		br.close();
		bw.close();
	}
}