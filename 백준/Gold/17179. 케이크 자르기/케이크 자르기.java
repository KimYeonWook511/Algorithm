import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[M + 1];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[M] = L;
		
		for (int t = 0; t < N; t++) {
			int Q = Integer.parseInt(br.readLine());
			
			int left = 0;
			int right = L;
			while (left <= right) {
				int mid = (left + right) >> 1;
			
				int cnt = 0;
				int temp = 0;
				for (int i = 0; i <= M; i++) {
					if (arr[i] - temp < mid) continue;
					
					cnt++;
					temp = arr[i];
				}
				
				if (cnt > Q) left = mid + 1;
				else right = mid - 1;
			}
			
			sb.append(right).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}