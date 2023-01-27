import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m;
	static boolean board[][]; // White : true / Black : false
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n][m];
		
		for (int row = 0; row < n; row++) {
			String line = br.readLine();
			
			for (int col = 0; col < m; col++) {
				if (line.charAt(col) == 'W') board[row][col] = true;
			}
		}
		
		int min = 64;
		
		for (int sr = 0; sr <= n - 8; sr++) {
			for (int sc = 0; sc <= m - 8; sc++) {
				int result = count(sr, sc, true); // W부터 시작
				if (result < min) min = result;
				
				result = count(sr, sc, false); // B부터 시작
				if (result < min) min = result;
			}
		}
		
		bw.write(Integer.toString(min));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int count(int sr, int sc, boolean isW) {
		int cnt = 0; // 칠하는 개수
		
		for (int row = sr; row < sr + 8; row++) {
			for (int col = sc; col < sc + 8; col++) {
				if (board[row][col] != isW) cnt++;
				
				isW = !isW;
			}
			isW = !isW; // 줄 바뀔 때
		}
		
		return cnt;
	}
}