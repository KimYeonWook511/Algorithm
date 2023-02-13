import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int sudoku[][] = new int[9][9];
	static int blankCnt;
	static int result[][] = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		
		for (int row = 0; row < 9; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int col = 0; col < 9; col++) {
				sudoku[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		fill(0, 0);
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				bw.write(result[r][c] + " ");
			}
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	static void fill(int row, int col) throws IOException {
		if (row == 9) { // 행의 끝 (재귀 종료)
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					result[r][c] = sudoku[r][c];
				}
			}
			return;
		}
		
		if (col == 9) { // 열의 끝
			fill(row + 1, 0); 
			return;
		}
		
		if (sudoku[row][col] != 0) { // 빈칸이 아닌 경우 열 이동
			fill(row, col + 1);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (check(row, col, i)) {
				// 숫자가 중복되지 않는 경우
				sudoku[row][col] = i;
				fill(row, col + 1);
			}
			
			sudoku[row][col] = 0;
		}
	}
	
	static boolean check(int row, int col, int num) { // 해당 숫자 사용 가능 확인
		for (int i = 0; i < 9; i++) { // 열 검사
			if (sudoku[row][i] == num) return false; // 열 검사
			if (sudoku[i][col] == num) return false; // 행 검사
		}
		
		for (int r = row / 3 * 3; r < row / 3 * 3 + 3; r++) { // 사각형 검사
			for (int c = col / 3 * 3; c < col / 3 * 3 + 3; c++) {
				if (sudoku[r][c] == num) return false;
			}
		}
		
		return true;
	}
}