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

		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int tree[] = new int[t + 1];
		int dp[][] = new int[w + 2][t + 1];
		int max = 0;
		
		for (int i = 1; i <= t; i++) {
			tree[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		for (int r = 1; r <= w + 1; r++) {
			for (int c = 1; c <= t; c++) {
				dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r][c - 1]);
				
				if (r % 2 != tree[c]) dp[r][c]++;
			}
			max = Math.max(max, dp[r][t]);
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
}