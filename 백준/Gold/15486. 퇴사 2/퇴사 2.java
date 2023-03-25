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
		int dp[] = new int[n + 2];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			dp[i] = Math.max(dp[i], dp[i - 1]);
			
			if (i + t <= n + 1) dp[i + t] = Math.max(dp[i + t], dp[i] + p);
		}
		
		bw.write(Integer.toString(Math.max(dp[n], dp[n + 1])));
		bw.flush();

		br.close();
		bw.close();
	}
}