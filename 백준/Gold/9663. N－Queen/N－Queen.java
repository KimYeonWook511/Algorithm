import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int colArr[];
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		colArr = new int[n];
		
		for (int col = 0; col < n; col++) {
			cal(0, col); // 첫 번째 퀸 말
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void cal(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (col == colArr[i]) return; // 같은 열에 위치
			if (Math.abs(row - i) == Math.abs(col - colArr[i])) return; // 대각선에 위치
		}
		
		if (row == n - 1) {
			// 마지막 행
			result++;
			return;
		}
		
		colArr[row] = col; // 퀸이 놓인 열 위치
		
		for (int i = 0; i < n; i++) {
			cal(row + 1, i);
		}
	}
}