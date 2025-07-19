import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (x < y) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
				
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int dp[] = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for (int k = 0; k < i; k++) {
				if (arr[k][0] > arr[i][0] || arr[k][1] > arr[i][1]) continue; 
					
				dp[i] = Math.max(dp[i], dp[k] + 1);
			}
			
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
		
		br.close();
	}
}