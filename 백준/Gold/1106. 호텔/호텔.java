import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int minCustomer = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int dp[][] = new int[minCustomer + 1][n + 1];
		int price[] = new int[n + 1];
		int customer[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			
			price[i] = Integer.parseInt(st.nextToken());
			customer[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r <= minCustomer; r++) {
			dp[r][0] = 100_001;
					
			for (int c = 1; c <= n; c++) {
				if (customer[c] >= r) dp[r][c] = Math.min(dp[r][c - 1], price[c]);
				else dp[r][c] = Math.min(dp[r][c - 1], dp[r - customer[c]][c] + price[c]);
			}
		}
		
		System.out.println(dp[minCustomer][n]);
		
		br.close();
	}
}