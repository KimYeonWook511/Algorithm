import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, cnt[] = new int[2];
	static char arr[][][], ch;
	static boolean chk[][][];
	static String line;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		arr = new char[2][N][N]; // 정상, 색약
		chk = new boolean[2][N][N];
		
		for (int r = 0; r < N; r++) {
			line = br.readLine();
			
			for (int c = 0; c < N; c++) {
				ch = line.charAt(c);
				
				arr[0][r][c] = ch;
				
				if (ch != 'B') ch = 'R';
				
				arr[1][r][c] = ch;
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!chk[0][r][c]) func(r, c, 0); // 정상
				if (!chk[1][r][c]) func(r, c, 1); // 색약
			}
		}
		
		System.out.println(cnt[0] + " " + cnt[1]);
		
		br.close();
	}
	
	static void func(int r, int c, int dim) {
		Deque<int[]> deque = new ArrayDeque<>();
		
		deque.offerLast(new int[] {r, c});		
		
		while (!deque.isEmpty()) {
			int cur[] = deque.pollFirst();
			int nr = 0;
			int nc = 0;
			
			for (int i = 0; i < 4; i++) {
				nr = cur[0] + d[i][0];
				nc = cur[1] + d[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (chk[dim][nr][nc]) continue;
				if (arr[dim][r][c] != arr[dim][nr][nc]) continue; 
				
				chk[dim][nr][nc] = true;
				deque.offerLast(new int[] {nr, nc});
			}
		}
		
		cnt[dim]++;
	}
}