import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			
			arr[A][B] = 1;
			arr[B][A] = -1;
		}
		
		for (int m = 0; m < N; m++) {
			for (int s = 0; s < N; s++) {
				if (arr[s][m] == 0) continue;
				
				for (int e = 0; e < N; e++) {
					if (arr[s][m] == 1 && arr[m][e] == 1) arr[s][e] = 1;
					if (arr[s][m] == -1 && arr[m][e] == -1) arr[s][e] = -1;
				}
			}
		}
        
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			
			for (int k = 0; k < N; k++) {
				if (arr[i][k] == 0) cnt++;
			}
			
			sb.append(cnt - 1).append("\n"); // 나 자신 빼기
		}

		System.out.println(sb);
		
		br.close();
	}
}