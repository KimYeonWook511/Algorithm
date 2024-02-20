import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C, arr[][], max, d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, nr, nc, chk[][];
	static String str;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		chk = new int[R][C];
		
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			str = br.readLine();

			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c) - 'A';
			}
		}
		
		func(0, 0, 1, (1 << arr[0][0]));

		System.out.println(max);

		br.close();
	}
	
	static void func(int r, int c, int cnt, int bit) {
		if (max == 26) return;
		
		max = Math.max(max, cnt);

		chk[r][c] = bit;
		
		for (int i = 0; i < 4; i++) {
			nr = r + d[i][0];
			nc = c + d[i][1];
			
			if (nr < 0 || nc < 0) continue;
			if (nr >= R || nc >= C) continue;
			if ((bit & (1 << arr[nr][nc])) != 0) continue;
			if ((bit | (1 << arr[nr][nc])) == chk[nr][nc]) continue;
			
			func(nr, nc, cnt + 1, bit | (1 << arr[nr][nc]));
		}
	}
}