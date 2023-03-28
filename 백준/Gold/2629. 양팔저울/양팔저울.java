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
		boolean dp[][] = new boolean[n + 1][15001];
		int w[] = new int[n + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][0] = true;
		dp[1][w[1]] = true;
		
		for (int r = 2; r <= n; r++) {
			for (int c = 0; c <= 15000; c++) {
				if (dp[r - 1][c]) {
					dp[r][c] = true;
					if (c + w[r] <= 15000) dp[r][c + w[r]] = true;
					dp[r][Math.abs(c - w[r])] = true;
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < m; run++) {
			int bead = Integer.parseInt(st.nextToken());
			
			if (bead > 15000) bw.write("N ");
			else bw.write(dp[n][bead] ? "Y " : "N ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}