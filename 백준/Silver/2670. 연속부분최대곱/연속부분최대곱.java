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
		double dp[] = new double[n + 1];
		double max = 0;
		
		for (int i = 1; i <= n; i++) {
			double num = Double.parseDouble(br.readLine());
			
			dp[i] = Math.max(num, dp[i - 1] * num);
			max = Math.max(max, dp[i]);
		}
		
		bw.write(String.format("%.3f", max));
		bw.flush();

		br.close();
		bw.close();
	}
}