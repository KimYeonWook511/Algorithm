import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int vip[] = new int[m + 2];
		int dp[] = new int[41];
		int result = 1;
		
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		for (int i = 1; i <= m; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		vip[m + 1] = n + 1;
		
		for (int i = 1; i < vip.length; i++) {
			result *= dp[vip[i] - vip[i - 1] - 1];
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
}