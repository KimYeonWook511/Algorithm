import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[][], virus[][], virusCnt, safeCnt, max;
	static Deque<int[]> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 2][M + 2];
		virus = new int[64][2];
		
		for (int r = 1 ; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				
				if (arr[r][c] == 0) {
					safeCnt++;
					
				} else if (arr[r][c] == 2) {
					virus[virusCnt][0] = r;
					virus[virusCnt][1] = c;
					virusCnt++;
				}
			}
			
			arr[r][0] = arr[r][M + 1] = 1;
		}
		
		for (int c = 1; c <= M; c++) {
			arr[0][c] = arr[N + 1][c] = 1;
		}
		
		func(1, 1, 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	static void func(int r, int c, int cnt) {
		if (cnt == 3) {
			bfs();
			
			return;
		}
		
		for (int nr = r; nr <= N; nr++) {
			for (int nc = 0; nc <= M; nc++) {
				if (arr[nr][nc] != 0) continue;
				
				arr[nr][nc] = 1;
				func(nr, nc, cnt + 1);
				arr[nr][nc] = 0;
			}
		}
	}
	
	static void bfs() {
		for (int i = 0; i < virusCnt; i++) {
			deque.offer(virus[i]);
		}
		
		int cnt = safeCnt - 3; // 벽 세 개
		boolean chk[][] = new boolean[N + 2][M + 2];
		
		while (!deque.isEmpty()) {
			int cur[] = deque.poll();
			int r = cur[0];
			int c = cur[1];
			
			if (!chk[r - 1][c] && arr[r - 1][c] == 0) {
				chk[r - 1][c] = true;
				cnt--;
				deque.offer(new int[] {r - 1, c});
			}
			
			if (!chk[r + 1][c] && arr[r + 1][c] == 0) {
				chk[r + 1][c] = true;
				cnt--;
				deque.offer(new int[] {r + 1, c});
			}
			
			if (!chk[r][c - 1] && arr[r][c - 1] == 0) {
				chk[r][c - 1] = true;
				cnt--;
				deque.offer(new int[] {r, c - 1});
			}
			
			if (!chk[r][c + 1] && arr[r][c + 1] == 0) {
				chk[r][c + 1] = true;
				cnt--;
				deque.offer(new int[] {r, c + 1});
			}
		}
		
		max = Math.max(max, cnt);
	}
}