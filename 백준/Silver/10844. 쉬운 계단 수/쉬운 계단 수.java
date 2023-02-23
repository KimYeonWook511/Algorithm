import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 2][10];
		
		for (int r = 0; r <= 1; r++) {
			for (int c = 1; c <= 9; c++) {
				arr[r][c] = 1;
			}
		}
		
		for (int r = 2; r <= n; r++) {
			for (int c = 1; c <= 9; c++) {
				if (c == 1) arr[r][c] = (arr[r - 2][c] + arr[r - 1][c + 1]) % 1_000_000_000; // 1
				else if (c == 9) arr[r][c] = arr[r - 1][c - 1] % 1_000_000_000; // 9
				else arr[r][c] = (arr[r - 1][c - 1] + arr[r - 1][c + 1]) % 1_000_000_000; // 2 ~ 8
			}
		}
		
		int sum = 0;
		
		for (int c = 1; c <= 9; c++) {
			sum += arr[n][c];
			sum %= 1_000_000_000;
		}
		
		bw.write(Integer.toString(sum));
		bw.flush();

		br.close();
		bw.close();
	}
}