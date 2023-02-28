import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		
		for (int r = 1; r <= str1.length(); r++) {
			for (int c = 1; c <= str2.length(); c++) {
				if (str1.charAt(r - 1) == str2.charAt(c - 1)) dp[r][c] = dp[r - 1][c - 1] + 1;
				else dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
			}
		}
		
		bw.write(Integer.toString(dp[str1.length()][str2.length()]));
		bw.flush();

		br.close();
		bw.close();
	}
}