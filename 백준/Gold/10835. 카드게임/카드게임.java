import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, a[], b[], dp[][];
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		dp = new int[n][n];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n; i++) {
			a[i] = Integer.parseInt(st1.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
			
			for (int c = 0; c < n; c++) {
				dp[i][c] = -1; // 아직 계산되지 않았다는 뜻
			}
		}
		
		System.out.println(cal(0, 0));
		
		br.close();
	}
	
	public static int cal(int left, int right) {
		if (left == n || right == n) return 0;
		
		if (dp[left][right] != -1) return dp[left][right]; // 이미 계산 되었음
		
		if (a[left] > b[right]) dp[left][right] = cal(left, right + 1) + b[right];
		else dp[left][right] = Math.max(cal(left + 1, right), cal(left + 1, right + 1)); 
			
		return dp[left][right];
	}
}