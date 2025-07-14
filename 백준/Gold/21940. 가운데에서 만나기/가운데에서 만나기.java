import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int T = Integer.parseInt(st.nextToken());
			
			arr[A][B] = T;
		}
		
		int K = Integer.parseInt(br.readLine());
		int nums[] = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int m = 0; m < N; m++) {
			for (int s = 0; s < N; s++) {
				if (s == m) continue;
				
				for (int e = 0; e < N; e++) {
					if (s == e || arr[s][m] == 0 || arr[m][e] == 0) continue;
					
					if (arr[s][e] == 0) arr[s][e] = arr[s][m] + arr[m][e];
					else arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
				}
			}
		}

		int result[] = new int[N];
		int min = Integer.MAX_VALUE;
		for (int s = 0; s < N; s++) {
			int max = 0;
			for (int k = 0; k < K; k++) {
				max = Math.max(max, arr[s][nums[k]] + arr[nums[k]][s]);
			}
			
			result[s] = max;
			min = Math.min(min, max);
		}
		
		for (int i = 0; i < N; i++) {
			if (min != result[i]) continue;
			
			sb.append(i + 1).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}