import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String input = br.readLine();
		boolean dp[][] = new boolean[input.length() + 1][input.length()]; // r : len, c : input의 startIdx
		int cntDP[] = new int[input.length() + 1];
		
		for (int c = 0; c < input.length(); c++) {
			// 초기 셋팅
			dp[0][c] = true;
			dp[1][c] = true;
			cntDP[c] = input.length() - c;
		}

		for (int r = 2; r <= input.length(); r++) {
			for (int c = 0; c <= input.length() - r; c++) {
				if (input.charAt(c) == input.charAt(c + r - 1)) dp[r][c] = dp[r - 2][c + 1];
			}
		}
		
		for (int c = input.length() - 1; c >= 0; c--) {
			for (int r = 1; r <= input.length() - c; r++) {
				if (dp[r][c]) cntDP[c] = Math.min(cntDP[c], cntDP[c + r] + 1);
			}
		}
		
		bw.write(Integer.toString(cntDP[0]));
		bw.flush();

		br.close();
		bw.close();
	}
}