import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int dp[] = new int[(int)Math.pow(2, n)]; // 처음은 0
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int pow = (int)Math.pow(2, i);
			
			if (num == s) cnt++;
			
			for (int k = 1; k < pow; k++) {
				dp[pow + k - 1] = dp[k] + num;
				
				if (dp[pow + k - 1] == s) cnt++;
			}
			
			dp[pow * 2 - 1] = num;
		}

		System.out.println(cnt);
		
		br.close();
	}
}