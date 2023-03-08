import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer coinArr[] = new Integer[n];
		int dp[] = new int[k + 1];
		int overCnt = 0;
		
		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			
			if (coin <= k) {
				coinArr[i] = coin;
			} else {
				coinArr[i] = 0;
				overCnt++; // 반복 횟수 줄이기 위한 카운트
			}
		}
		
		Arrays.sort(coinArr, Collections.reverseOrder());
		
		for (int c = 0; c < n - overCnt; c++) {
			for (int i = 1; i <= k; i++) {
				int val = i - coinArr[c];
				
				if (val == 0) dp[i]++;
				else if (val > 0) dp[i] += dp[val];
			}
		}
		
		bw.write(Integer.toString(dp[k]));
		bw.flush();

		br.close();
		bw.close();
	}
}