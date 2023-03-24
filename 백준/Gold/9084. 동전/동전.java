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
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			Integer.parseInt(br.readLine()); // n
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int dp[] = new int[10001];
					
			while (st.hasMoreTokens()) {
				int coin = Integer.parseInt(st.nextToken());
				dp[coin]++;
				
				for (int i = coin; i <= m; i++) {
					dp[i] += dp[i - coin];
				}
			}
			
			bw.write(dp[m] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}