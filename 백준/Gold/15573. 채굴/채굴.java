import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < M; c++) {
			pq.offer(new int[] {0, c, Integer.parseInt(st.nextToken())});
			arr[0][c] = Integer.MAX_VALUE;
		}
		
		for (int r = 1; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
			
			pq.offer(new int[] {r, 0, arr[r][0]});
			pq.offer(new int[] {r, M - 1, arr[r][M - 1]});
			
			arr[r][0] = arr[r][M - 1] = Integer.MAX_VALUE;
		}
		
		int max = 0;
		
		while (true) {
			int cur[] = pq.poll();
			
			max = Math.max(max, cur[2]);
			
			if (--K == 0) break;
			
			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= M) continue;
				if (arr[nr][nc] == Integer.MAX_VALUE) continue;
				
				pq.offer(new int[] {nr, nc, arr[nr][nc]});
				arr[nr][nc] = Integer.MAX_VALUE;
			}
		}

		System.out.println(max);
		
		br.close();
	}
}