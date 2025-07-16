import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];
			for (int s = 0; s < N; s++) {
				for (int e = 0; e < N; e++) {
					arr[s][e] = 1_000_000;
				}
				
				arr[s][s] = 0;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				
				arr[a][b] = arr[b][a] = c;
			}
			
			for (int m = 0; m < N; m++) {
				for (int s = 0; s < N; s++) {
					if (s == m) continue;
					
					for (int e = 0; e < N; e++) {
						arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
					}
				}
			}
			
			int K = Integer.parseInt(br.readLine());
			int friends[] = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				friends[i] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			int min = 1_000_000;
			int result = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				
				for (int k = 0; k < K; k++) {
					sum += arr[friends[k]][i];
				}
				
				if (sum < min) {
					min = sum;
					result = i;
				}
			}

			sb.append(result + 1).append("\n");
		}
		
		System.out.println(sb);

		br.close();
	}
}