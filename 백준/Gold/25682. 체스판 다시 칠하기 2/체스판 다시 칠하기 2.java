import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, k;
	static boolean board[][]; // white : true | black : false
	static int min = 4_000_000; // 2000 * 2000
	
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new boolean[n + 1][m + 1];
		int startW[][] = new int[n + 1][m + 1]; // W로 시작하는 보드
		int startB[][] = new int[n + 1][m + 1]; // B로 시작하는 보드

		for (int r = 1; r <= n; r++) {
			String line = br.readLine();

			for (int c = 1; c <= m; c++) {
				board[r][c] = line.charAt(c - 1) == 'W' ? true : false;
			}
		}
		
		count(startW, true);
		count(startB, false);
		
		for (int r = k; r <= n; r++) {
			for (int c = k; c <= m; c++) {
				int val = Math.min(startW[r][c] - (startW[r - k][c] + startW[r][c - k]) + startW[r - k][c - k], 
									startB[r][c] - (startB[r - k][c] + startB[r][c - k]) + startB[r - k][c - k]);
				
				min = Math.min(min, val);
			}
		}
		
		bw.write(Integer.toString(min));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	static void count(int chess[][], boolean firstColor) {
		boolean startColor = firstColor; // W : true | B : false
		
		for (int r = 1; r <= n; r++) {
			boolean isW = startColor;
			int sum = 0; // 같은 행의 합 
			
			for (int c = 1; c <= m; c++) {
				if (board[r][c] != isW) sum++;
				
				chess[r][c] = sum + chess[r - 1][c]; // 같은 행의 합 + 같은 열의 합 -> 직사각형의 합
				
				isW = !isW;
			}
			
			startColor = !startColor; // 줄 바뀔 때
		}
	}
}