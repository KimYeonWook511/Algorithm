import java.io.*;
import java.util.*;

public class Main {
	static class Status {
		int r1, c1;
		int r2, c2;
		int cnt;
		
		Status (int r1, int c1, int r2, int c2, int cnt) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.cnt = cnt;
		}
	}
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[N][M];
		int coin[][] = new int[2][2];
		int coinIdx = 0;
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			
			for (int c = 0; c < M; c++) {
				char ch = line.charAt(c);
				
				arr[r][c] = ch == '#';
				
				if (ch == 'o') {
					coin[coinIdx][0] = r;
					coin[coinIdx][1] = c;
					coinIdx++;
				}
			}
		}
		
		Deque<Status> deque = new ArrayDeque<>();
		boolean visited[][][][] = new boolean[N][M][N][M];
		deque.offer(new Status(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0));
		visited[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]] = true;
		
		int result = -1;
		while (!deque.isEmpty()) {
			Status cur = deque.poll();
			
			if (cur.cnt == 10) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr1 = cur.r1 + dr[d];
				int nc1 = cur.c1 + dc[d];
				int nr2 = cur.r2 + dr[d];
				int nc2 = cur.c2 + dc[d];
				
				// 범위 검사
				boolean isOut1 = nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= M;
				boolean isOut2 = nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= M;
				if (isOut1 && isOut2) continue;
				if (isOut1 || isOut2) {
					result = cur.cnt + 1;
					break;
				}
				
				// 벽 검사
				boolean isWall1 = arr[nr1][nc1];
				boolean isWall2 = arr[nr2][nc2];
				if (isWall1 && isWall2) continue;
				if (isWall1) {
					nr1 = cur.r1;
					nc1 = cur.c1;
				} else if (isWall2) {
					nr2 = cur.r2;
					nc2 = cur.c2;
				}
				
				if (!visited[nr1][nc1][nr2][nc2]) {
					deque.offer(new Status(nr1, nc1, nr2, nc2, cur.cnt + 1));
					visited[nr1][nc1][nr2][nc2] = true;
				}
			}
			
			if (result != -1) break;
		}
		
		System.out.println(result);
		
		br.close();
	}
}