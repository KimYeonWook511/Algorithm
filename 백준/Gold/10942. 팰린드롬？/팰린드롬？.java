import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		boolean dp[][] = new boolean[n + 1][n + 1]; // row : len / col : startIdx
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[1][i] = true;
		}
		
		for (int c = 1; c <= n - 1; c++) {
			if (arr[c] == arr[c + 1]) dp[2][c] = true;
		}
		
		for (int r = 3; r <= n; r++) {
			for (int c = 1; c <= n - r + 1; c++) {
				if (arr[c] == arr[c + r - 1] && dp[r - 2][c + 1]) dp[r][c] = true;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < m; run++) {
			st = new StringTokenizer(br.readLine());
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			
			bw.write(dp[endIdx - startIdx + 1][startIdx] ? "1\n" : "0\n");
		}

		br.close();
		bw.close();
	}
}