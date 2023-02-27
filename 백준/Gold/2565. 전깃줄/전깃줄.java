import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 1][2]; // [][0] : left / [][1] : right
		int dp[] = new int[n + 1];
		int max = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			arr[run][0] = Integer.parseInt(st.nextToken());
			arr[run][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			
			for (int k = 1; k < i; k++) {
				if (arr[i][1] > arr[k][1] && dp[i] < dp[k] + 1) {
					dp[i] = dp[k] + 1;
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		bw.write(Integer.toString(n - max));
		bw.flush();

		br.close();
		bw.close();
	}
	
}