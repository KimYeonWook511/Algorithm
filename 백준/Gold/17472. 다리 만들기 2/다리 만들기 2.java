import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int parent[][];
	static Map<Integer, int[]> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[N][M];
		parent = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				if (st.nextToken().charAt(0) == '1') arr[r][c] = true;
			}
		}
		
		Deque<int[]> unionDeque = new ArrayDeque<>();
		Deque<int[]> deque = new ArrayDeque<>();
		
		boolean chk[][] = new boolean[N][M];
		int idx = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!arr[r][c] || parent[r][c] != 0) continue;
				
				chk[r][c] = true;
				unionDeque.offer(new int[] {r, c});
				map.put(++idx, new int[] {r, c});
				parent[r][c] = idx;
				
				while (!unionDeque.isEmpty()) {
					int cur[] = unionDeque.poll();
					boolean edge = false;
					
					int nr, nc;
					for (int d = 0; d < 4; d++) {
						nr = cur[0] + dr[d];
						nc = cur[1] + dc[d];
						
						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= M) continue;
						if (chk[nr][nc]) continue;
						
						if (!arr[nr][nc]) {
							edge = true;
							continue;
						}
						
						chk[nr][nc] = true;
						unionDeque.offer(new int[] {nr, nc});
						parent[nr][nc] = idx;
					}
					
					if (edge) deque.offer(cur);
				}
			}
		}
		
		int min[][] = new int[idx + 1][idx + 1];
		int minLen[] = new int[idx + 1]; // MST
		
		for (int r = 1; r <= idx; r++) {
			for (int c = 1; c <= idx; c++) {
				min[r][c] = Integer.MAX_VALUE;
			}
			
			minLen[r] = Integer.MAX_VALUE;
		}
		
		while (!deque.isEmpty()) {
			int cur[] = deque.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0];
				int nc = cur[1];
				int len = -1;
				
				while (true) {
					nr += dr[d];
					nc += dc[d];
					len++;
					
					if (nr < 0 || nc < 0) break;
					if (nr >= N || nc >= M) break;
					
					if (!arr[nr][nc]) continue; // 바다
					
					if (find(parent[cur[0]][cur[1]]) == find(parent[nr][nc])) break; // 같은 섬
					
					if (len > 1) min[parent[cur[0]][cur[1]]][parent[nr][nc]] = Math.min(min[parent[cur[0]][cur[1]]][parent[nr][nc]], len); 
					
					break;
				}
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		pq.offer(new int[] {1, 0});

		boolean chk2[] = new boolean[idx + 1]; 
		int cnt = idx;
		int sum = 0;
		
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			
			if (chk2[cur[0]]) continue;
			
			chk2[cur[0]] = true;
			sum += cur[1];
			if (--cnt == 0) break;
			
			for (int next = 1; next <= idx; next++) {
				if (chk2[next]) continue;
				if (minLen[next] <= min[cur[0]][next]) continue;
				
				minLen[next] = min[cur[0]][next];
				pq.offer(new int[] {next, minLen[next]});
			}
		}
		
		System.out.println(cnt == 0 ? sum : "-1");
		
		br.close();
	}
	
	static int find(int x) {
		int cur[] = map.get(x);
		
		if (parent[cur[0]][cur[1]] == x) return x;
		
		return parent[cur[0]][cur[1]] = find(x);
	}
}