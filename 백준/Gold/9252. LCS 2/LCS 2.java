import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for (int r = 1; r <= s1.length(); r++) {
			for (int c = 1; c <= s2.length(); c++) {
				if (s1.charAt(r - 1) == s2.charAt(c - 1)) dp[r][c] = dp[r - 1][c - 1] + 1;
				else dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
			}
		}
		
		int len = dp[s1.length()][s2.length()];
		char result[] = new char[len + 1];
		
		int r = s1.length();
		int c = s2.length();
		
		while (r > 0) {
			if (dp[r][c] == dp[r - 1][c]) r--;
			else if (dp[r][c] == dp[r][c - 1]) c--;
			else if (dp[r - 1][c] == dp[r][c - 1]) {
				result[len--] = s1.charAt(r - 1); // s2.charAt(c - 1)동일
				r--;
				c--;
			}
		}
		
		bw.write(dp[s1.length()][s2.length()] + "\n");
		
		for (int i = 1; i <= dp[s1.length()][s2.length()]; i++) {
			bw.write(result[i]);
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}