import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C, arr[][], max;
	static boolean chk[] = new boolean[26];
	static String str;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			str = br.readLine();
			
			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c) - 'A';
			}
		}
		
		func(0, 0, 0);

		System.out.println(max);

		br.close();
	}
	
	static void func(int r, int c, int cnt) {
		if (r < 0 || c < 0) {
			max = Math.max(max, cnt);

			return;
		}

		if (r >= R || c >= C) {
			max = Math.max(max, cnt);

			return;
		}

		if (chk[arr[r][c]]) {
			max = Math.max(max, cnt);

			return;
		}

		chk[arr[r][c]] = true;
		func(r - 1, c, cnt + 1);
		func(r, c + 1, cnt + 1);
		func(r + 1, c, cnt + 1);
		func(r, c - 1, cnt + 1);
		chk[arr[r][c]] = false;
	}
}