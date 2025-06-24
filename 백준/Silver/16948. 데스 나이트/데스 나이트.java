import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c, cnt;
		
		Node (int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int dr[] = {-2, -2, 0, 0, 2, 2};
	static int dc[] = {-1, 1, -2, 2, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		Deque<Node> deque = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		deque.offer(new Node(r1, c1, 0));
		visited[r1][c1] = true;
		
		int result = -1;
		while (!deque.isEmpty()) {
			Node cur = deque.poll();
			
			if (cur.r == r2 && cur.c == c2) {
				result = cur.cnt;
				break;
			}
			
			for (int d = 0; d < 6; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				deque.offer(new Node(nr, nc, cur.cnt + 1));
				visited[nr][nc] = true;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}