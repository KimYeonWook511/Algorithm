import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static boolean isBlank[][];
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		isBlank = new boolean[n][n];
		
		star(3, 0);
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (isBlank[row][col]) bw.write(" ");
				else bw.write("*");
			}
			bw.write("\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int star(int num, int k) {
		if (num > n) return 0;
		
		for (int r = 0; r * num < n; r++) {
			for (int c = 0; c * num < n; c++) {
				for (int row = r * num; row < r * num + Math.pow(3, k + 1); row++) {
					for (int col = c * num; col < c * num + Math.pow(3, k + 1); col++) {
						if (row >= Math.pow(3, k) + r * num && row < Math.pow(3, k) * 2 + r * num
								&& col >= Math.pow(3, k) + c * num && col < Math.pow(3, k) * 2 + c * num) isBlank[row][col] = true;
					}
				}
			}
		}
		
		return star(num * 3, k + 1);
	}
}
