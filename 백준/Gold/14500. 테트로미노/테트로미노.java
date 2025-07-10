import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][], result;
	static boolean visited[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				func(r, c, 0, 0);
				visited[r][c] = false;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
	
	static void func(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0) continue;
			if (nr >= N || nc >= M) continue;
			if (visited[nr][nc]) continue;
			
			if (cnt == 2) {
				visited[nr][nc] = true;
				func(r, c, cnt + 1, sum + arr[nr][nc]);
				visited[nr][nc] = false;
			}
			
			visited[nr][nc] = true;
			func(nr, nc, cnt + 1, sum + arr[nr][nc]);
			visited[nr][nc] = false;
		}
	}
}