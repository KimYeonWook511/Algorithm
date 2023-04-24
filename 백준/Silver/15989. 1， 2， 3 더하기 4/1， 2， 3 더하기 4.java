import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int dp[] = new int[10001];
		
		for (int num = 3; num > 0; num--) {
			dp[num]++; // dp[0] = 1 넣고 i = num 해도 됨
			
			for (int i = num + 1; i <= 10000; i++) {
				dp[i] += dp[i - num];
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}

		br.close();
		bw.close();
	}
}