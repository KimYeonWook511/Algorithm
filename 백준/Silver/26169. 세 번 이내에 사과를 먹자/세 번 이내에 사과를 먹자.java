import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int arr[][] = new int[5][5];
	static int row, col;
	static int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < 5; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		func(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0);
		
		System.out.println(flag ? 1 : 0);
		
		br.close();
	}
	
	static void func(int r, int c, int depth, int cnt) {
		if (depth == 4) {
			if (cnt >= 2) flag = true; 
			
			return;
		}
		
		if (arr[r][c] == -1) return;
		if (arr[r][c] == 1) cnt++;
		
		int nr = 0;
		int nc = 0;
		int temp = arr[r][c];
		
		for (int i = 0; i < 4; i++) {
			nr = r + d[i][0];
			nc = c + d[i][1];
			
			if (nr < 0 || nc < 0) continue;
			if (nr >= 5 || nc >= 5) continue;
			
			arr[r][c] = -1;
			func(nr, nc, depth + 1, cnt);
			arr[r][c] = temp;
		}
	}
}