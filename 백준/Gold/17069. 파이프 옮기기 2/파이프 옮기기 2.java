import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long arr[][][] = new long[N + 1][N + 1][3]; // 동, 남동, 남
		boolean chk[][] = new boolean[N + 1][N + 1];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= N; c++) {
				if (st.nextToken().charAt(0) == '1') chk[r][c] = true;
			}
		}
		
		arr[1][2][0] = 1;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 3; c <= N; c++) {
				if (chk[r][c]) continue;
				
				arr[r][c][0] = arr[r][c - 1][0] + arr[r][c - 1][1]; // 가로로 들어오는 것
				arr[r][c][2] = arr[r - 1][c][1] + arr[r - 1][c][2]; // 세로로 들어오는 것
				
				if (!chk[r - 1][c] && !chk[r][c - 1]) arr[r][c][1] = arr[r - 1][c - 1][0] + arr[r - 1][c - 1][1] + arr[r - 1][c - 1][2]; 
			}
		}
		
		System.out.println(arr[N][N][0] + arr[N][N][1] + arr[N][N][2]);
		
		br.close();
	}
}