import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][], shark[], sharkSize[], time;
	static int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		shark = new int[2];
		sharkSize = new int[]{2, 0};
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				
				if (arr[r][c] == 9) {
					shark[0] = r;
					shark[1] = c;
					arr[r][c] = 0;
				}
			}
		}

		while (bfs());
		
		System.out.println(time);
		
		br.close();
	}
	
	static boolean bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] {shark[0], shark[1], 1});
		
		boolean chk[][] = new boolean[N][N];
		chk[shark[0]][shark[1]] = true;
		int target[] = {0, 0, 10000};
		
		while (!deque.isEmpty()) {
			int cur[] = deque.pollFirst();
			
			if (cur[2] > target[2]) break;
			
			int nr, nc;
			
			for (int i = 0; i < 4; i++) {
				nr = cur[0] + d[i][0];
				nc = cur[1] + d[i][1];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= N) continue;
				if (chk[nr][nc]) continue;
				if (arr[nr][nc] > sharkSize[0]) continue;
				
				if (arr[nr][nc] != 0 && arr[nr][nc] < sharkSize[0]) {
					if (target[2] == 10000) {
						target[0] = nr;
						target[1] = nc;
						target[2] = cur[2];
						
					} else if (nr < target[0]) {
						target[0] = nr;
						target[1] = nc;
						
					} else if (nr == target[0] && nc < target[1]) {
						target[1] = nc;
					}
					
					continue;
				}
				
				chk[nr][nc] = true;
				deque.offerLast(new int[] {nr, nc, cur[2] + 1});
			}
		}
		
		if (target[2] == 10000) return false;
		
		sharkSize[1]++;
		
		if (sharkSize[0] == sharkSize[1]) {
			sharkSize[0]++;
			sharkSize[1] = 0;
		}
		
		arr[target[0]][target[1]] = 0;
		time += target[2];
		shark[0] = target[0];
		shark[1] = target[1];
		
		return true;
	}
}