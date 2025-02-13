import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int arr[][] = new int[P][2];

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
 
		int dp[] = new int[D + 1];
		dp[0] = Integer.MAX_VALUE;

		for (int i = 0; i < P; i++) {
			int min = arr[i][0];

			for (int k = D; k >= min; k--) {
				dp[k] = Math.max(dp[k], Math.min(arr[i][1], dp[k - min]));
			}
		}

        System.out.println(dp[D]);

        br.close();
    }
}