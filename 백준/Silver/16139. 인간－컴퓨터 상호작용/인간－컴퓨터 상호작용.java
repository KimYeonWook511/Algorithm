import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		String s = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int dp[][] = new int[26][s.length() + 1];
		
		for (int r = 0; r < 26; r++) {
			for (int i = 0; i < s.length(); i++) {
				int alphabet = s.charAt(i) - 97;
				
				dp[r][i + 1] = (r == alphabet ? dp[r][i] + 1 : dp[r][i]);
			}
		}
		
		for (int run = 0; run < q; run++) {
			st = new StringTokenizer(br.readLine());
			
			int alphabet = st.nextToken().charAt(0) - 97;
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			
			bw.write(dp[alphabet][endIdx + 1] - dp[alphabet][startIdx] + "\n");
		}
		
		
		bw.flush();

		br.close();
		bw.close();
	}
}