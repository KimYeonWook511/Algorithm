import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, k, p, n;
	
	public static void main(String[] args) throws IOException {

		t = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		int dp[] = new int[t + 1];
		
		dp[0] = 1;
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			p = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken()) + 1;
			
			for (int v = t; v >= p; v--) {
				for (int cnt = 1; cnt < n; cnt++) {
					if (v < p * cnt) break;
					dp[v] += dp[v - p * cnt];
				}
			}
		}
		
		System.out.println(dp[t]);

		br.close();
	}
}