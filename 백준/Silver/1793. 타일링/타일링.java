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
		
		BigInteger dp[] = new BigInteger[251];
		
		dp[0] = new BigInteger("1"); // nC0
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for (int i = 3; i <= 250; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
		}
		
		String num;
		while ((num = br.readLine()) != null) {
			bw.write(dp[Integer.parseInt(num)] + "\n");
		}
		
		bw.close();
		br.close();
	}
}