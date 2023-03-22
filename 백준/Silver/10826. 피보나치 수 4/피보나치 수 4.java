import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		BigInteger dp[] = new BigInteger[n + 2];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		
		bw.write(dp[n].toString());
		bw.flush();

		br.close();
		bw.close();
	}
}