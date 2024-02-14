import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, cnt;
	static boolean arr[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new boolean[R + 2][C];
		String line = "";
		
		for (int r = 1; r <= R; r++) {
			line = br.readLine();
			
			for (int c = 0; c < C; c++) {
				if (line.charAt(c) == '.') arr[r][c] = true;
			}
		}

		for (int r = 1; r <= R; r++) {
			func(r, 0);
		}
		
		System.out.println(cnt);
		
		br.close();
	}
	
	static boolean func(int r, int c) {
		if (c == C - 1) {
			cnt++;
			
			return true;
		}
		
        arr[r][c] = false;

		if (arr[r - 1][c + 1] && func(r - 1, c + 1)) return true;
		
		if (arr[r][c + 1] && func(r, c + 1)) return true;
		
		if (arr[r + 1][c + 1] && func(r + 1, c + 1)) return true;

        return false;
	}
}