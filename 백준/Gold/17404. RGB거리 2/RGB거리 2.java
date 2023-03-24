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
		int color[][] = new int[n + 1][3];
		int min = 1_000_000;
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c <= 2; c++) {
				color[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <= 2; i++) { // startColor : r(0), g(1), b(2)
			int dp[] = new int[3];
			
			for (int k = 0; k <= 2; k++) {
				dp[k] = (i == k ? color[1][i] : 1_000_000);
			}
			
			for (int r = 2; r <= n; r++) {
				int red = color[r][0] + Math.min(dp[1], dp[2]);
				int green = color[r][1] + Math.min(dp[0], dp[2]);
				int blue = color[r][2] + Math.min(dp[0], dp[1]);
				
				dp[0] = red;
				dp[1] = green;
				dp[2] = blue;
			}
			
			if (i == 0) min = Math.min(min, Math.min(dp[1], dp[2]));
			else if (i == 1) min = Math.min(min, Math.min(dp[0], dp[2]));
			else if (i == 2) min = Math.min(min, Math.min(dp[0], dp[1]));
		}
		
		bw.write(Integer.toString(min));
		bw.flush();

		br.close();
		bw.close();
	}
}