import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());
		int dp[] = new int[11]; // n : 0 ~ 10 (0은 인덱스 맞추기)
		
		for (int r = 1; r <= 10; r++) {
			for (int c = 1; c <= Math.min(r, 3); c++) {
				dp[r] += (r - c == 0 ? 1 : dp[r - c]);
			}
		}
		
		for (int run = 0; run < t; run++) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}