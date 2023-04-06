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
		int L[] = new int[n + 1];
		int J[] = new int[n + 1];
		int dp[][] = new int[100][n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());		
		for (int i = 1; i <= n; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r < 100; r++) {
			for (int c = 1; c <= n; c++) {
				if (r >= L[c]) dp[r][c] = J[c] + dp[r - L[c]][c - 1];
				
				dp[r][c] = Math.max(dp[r][c], dp[r][c - 1]);
			}
		}
		
		bw.write(Integer.toString(dp[99][n]));
		bw.flush();

		br.close();
		bw.close();
	}
}