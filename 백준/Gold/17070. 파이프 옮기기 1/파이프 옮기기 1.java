import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][][] = new int[N + 1][N + 1][3]; // 동, 남동, 남
		boolean chk[][] = new boolean[N + 1][N + 1];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				if (st.nextToken().charAt(0) == '1') chk[r][c] = true;
			}
		}
		
		arr[0][1][0] = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 1; c < N; c++) {
				// 동
				if (!chk[r][c + 1]) arr[r][c + 1][0] = arr[r][c][0] + arr[r][c][1]; 
				
				// 남동
				if (!chk[r][c + 1] && !chk[r + 1][c + 1] && !chk[r + 1][c]) arr[r + 1][c + 1][1] = arr[r][c][0] + arr[r][c][1] + arr[r][c][2]; 
				
				// 남
				if (!chk[r + 1][c]) arr[r + 1][c][2] = arr[r][c][1] + arr[r][c][2];
			}
		}
		
		System.out.println(arr[N - 1][N - 1][0] + arr[N - 1][N - 1][1] + arr[N - 1][N - 1][2]);
		
		br.close();
	}
}