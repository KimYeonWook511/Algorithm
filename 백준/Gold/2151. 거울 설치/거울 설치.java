import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		char arr[][] = new char[N][N];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[3], o2[3]);
			}
		});
		int chk[][][] = new int[4][N][N];
		int end[] = new int[2];
		boolean isEnd = false;
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();

			for (int c = 0; c < N; c++) {
				arr[r][c] = line.charAt(c);

				for (int d = 0; d < 4; d++) {
					// 초기화
					chk[d][r][c] = Integer.MAX_VALUE;
				}
				
				if (arr[r][c] == '#') {
					if (isEnd) {
						end[0] = r;
						end[1] = c;
						continue;
					}
					
					int nr, nc;
					for (int d = 0; d < 4; d++) {
						nr = r + dr[d];
						nc = c + dc[d];
						
						chk[d][r][c] = 0;
						
						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= N) continue;
						if (arr[nr][nc] == '*') continue;
						
						pq.offer(new int[]{r, c, d, 0});
					}
					
					isEnd = true;
				}
			}
		}

		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int d = cur[2];
			int cnt = cur[3];
			
			if (r == end[0] && c == end[1]) {
				System.out.println(cnt);
				break;
			}
			
			int nr, nc;

			if (arr[r][c] == '.') {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= N) continue;
				if (cnt >= chk[d][nr][nc]) continue;
				if (arr[nr][nc] == '*') continue;
				
				pq.offer(new int[]{nr, nc, d, cnt});
				chk[d][nr][nc] = cnt;
				
				continue;
			}
			
			int ncnt;
			
			for (int nd = 0; nd < 4; nd++) { // 거울 설치
				if ((d + 2) % 4 == nd) continue; // 반대 방향
				
				nr = r + dr[nd];
				nc = c + dc[nd];
				ncnt = cnt + (nd == d ? 0 : 1);
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= N) continue;
				if (ncnt >= chk[nd][nr][nc]) continue;
				if (arr[nr][nc] == '*') continue;
				
				pq.offer(new int[]{nr, nc, nd, ncnt});
				chk[nd][nr][nc] = ncnt;
			}
		}

		br.close();
	}
}