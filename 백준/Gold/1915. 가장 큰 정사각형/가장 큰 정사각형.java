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

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n + 1][m + 1];
		int max = 0;
		
		for (int r = 1; r <= n; r++) {
			String line = br.readLine();
			
			for (int c = 1; c <= m; c++) {
				if (line.charAt(c - 1) == '1') {
					// 정사각형의 오른쪽 맨 아래 부분 네개 확인 
					// (s - 1의 변의 길이를 가지는 정사각형이 이루어지는지 확인한 값을 이용)
					dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
				}
				max = Math.max(max, dp[r][c]);
			}
		}
		
		bw.write(Integer.toString(max * max));
		bw.flush();

		br.close();
		bw.close();
	}
}