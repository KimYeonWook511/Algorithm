import java.io.*;
import java.util.*;

public class Main {
	static int d[][] = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		Deque<int[]> deque = new ArrayDeque<>();
		boolean arr[][][] = new boolean[H][N][M];
		int cnt = 0;
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				
				for (int c = 0; c < M; c++) {
					int val = Integer.parseInt(st.nextToken());
					
					if (val == 1) deque.offer(new int[] {h, r, c});
					else if (val == 0) {
						arr[h][r][c] = true;
						cnt++;
					}
				}
			}
		}
		
		int day = 0;
		
		while (!deque.isEmpty()) {
			if (cnt == 0) break;
			
			int size = deque.size();
			
			for (int i = 0; i < size; i++) {
				int cur[] = deque.poll();
				
				int nh, nr, nc;
				for (int k = 0; k < 6; k++) {
					nh = cur[0] + d[k][0];
					nr = cur[1] + d[k][1];
					nc = cur[2] + d[k][2];
					
					if (nh < 0 || nr < 0 || nc < 0) continue;
					if (nh >= H || nr >= N || nc >= M) continue;
					if (!arr[nh][nr][nc]) continue;
					
					arr[nh][nr][nc] = false;
					deque.offer(new int[] {nh, nr, nc});
					cnt--;
				}
			}
			
			day++;
		}
		
		System.out.println(cnt == 0 ? day : "-1");
		
		br.close();
	}
}