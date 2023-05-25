import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, a[], b[], dp[][], max;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		dp = new int[n + 1][n + 1];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n; i++) {
			a[i] = Integer.parseInt(st1.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}
		
		s(0, 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	public static void s(int left, int right) {
		if (left == n || right == n) {
			max = Math.max(max, dp[right][left]);
			return;
		}
		
		dp[right][left + 1] = Math.max(dp[right][left + 1], dp[right][left]);
		dp[right + 1][left + 1] = Math.max(dp[right + 1][left + 1], dp[right][left]);
		
		if (a[left] > b[right]) {
			dp[right + 1][left] = Math.max(dp[right + 1][left], dp[right][left] + b[right]);
			s(left, right + 1);
			
		} else {
			s(left + 1, right);
			s(left + 1, right + 1);
		}
	}
}