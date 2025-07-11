import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c, k, cnt;
		
		Node (int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
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
		int K = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[N][M];
		int visited[][] = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = line.charAt(c) == '1';
				visited[r][c] = Integer.MAX_VALUE;
			}
		}
		
		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(new Node(0, 0, 0, 1));
		visited[0][0] = 0;
		
		int result = -1;
		while (!deque.isEmpty()) {
			Node cur = deque.poll();
			
			if (cur.r == N - 1 && cur.c == M - 1) {
				result = cur.cnt;
				break;
			}
			
			if (cur.k > visited[cur.r][cur.c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= M) continue;
				
				int nk = arr[nr][nc] ? cur.k + 1 : cur.k;

				if (nk > K) continue;
				if (visited[nr][nc] <= nk) continue;
				
				deque.offer(new Node(nr, nc, nk, cur.cnt + 1));
				visited[nr][nc] = nk;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}