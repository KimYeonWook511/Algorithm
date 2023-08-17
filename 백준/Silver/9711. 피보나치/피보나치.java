import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		BigInteger dp[] = new BigInteger[10001];
		dp[1] = dp[2] = new BigInteger("1");
		
		for (int i = 3; i <= 10000; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		
		for (int run = 1; run <= t; run++) {
			st = new StringTokenizer(br.readLine());
			bw.write("Case #" + run + ": " + dp[Integer.parseInt(st.nextToken())].mod(BigInteger.valueOf(Long.parseLong(st.nextToken()))) + "\n");
		}
		
		br.close();
		bw.close();
	}
}