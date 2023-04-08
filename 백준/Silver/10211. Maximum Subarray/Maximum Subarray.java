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
			int n = Integer.parseInt(br.readLine());
			int dp[] = new int[n + 1];
			int max = -1000;
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				dp[i] = Math.max(num, dp[i - 1] + num);
				max = Math.max(max, dp[i]);
			}
			
			bw.write(max + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}