import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int arr[][] = new int[M + 1][M];
		
		int s = (M << 1) - 1;
		int a[] = new int[s + 1];
		
		for (int run = 0; run < N; run++) {
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			
			for (int i = 0; i < 2; i++) {
				idx += Integer.parseInt(st.nextToken());
				
				a[idx]++;
			}
			
			Integer.parseInt(st.nextToken()); // 버리기
		}
		
		int i = 0;
		arr[M][0] = 1;
		
		for (int r = M - 1; r >= 0; r--) {
			arr[r][0] = arr[r + 1][0] + a[i++];
		}
		
		for (int c = 1; c < M; c++) {
			arr[0][c] = arr[0][c - 1] + a[i++];
		}
		
		for (int c = M - 1; c > 0; c--) {
			for (int r = 1; r < M; r++) {
				arr[r][c] = arr[0][c];
			}
		}
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(arr[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}