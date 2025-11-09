import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;

		Node (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int map[][] = new int[501][501];
	static int visited[][] = new int[501][501];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			fill(x1, y1, x2, y2, 1);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			fill(x1, y1, x2, y2, -1);
		}

		for (int r = 0; r <= 500; r++) {
			for (int c = 0; c <= 500; c++) {
				visited[r][c] = Integer.MAX_VALUE;
			}
		}

		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(new Node(0, 0));
		visited[0][0] = 0;

		int answer = -1;
		while (!deque.isEmpty()) {
			Node cur = deque.poll();

			if (cur.r == 500 && cur.c == 500) {
				answer = visited[cur.r][cur.c];
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nc < 0) continue;
				if (nr > 500 || nc > 500) continue;
				if (map[nr][nc] == -1) continue;
				if (visited[nr][nc] <= visited[cur.r][cur.c] + map[nr][nc]) continue;

				if (map[nr][nc] == 1) deque.offerLast(new Node(nr, nc));
				else deque.offerFirst(new Node(nr, nc));
				visited[nr][nc] = visited[cur.r][cur.c] + map[nr][nc];
			}
		}

		System.out.println(answer);

		br.close();
	}

	static void fill(int r1, int c1, int r2, int c2, int val) {
		if (r1 > r2) {
			int temp = r1;
			r1 = r2;
			r2 = temp;
		}
		if (c1 > c2) {
			int temp = c1;
			c1 = c2;
			c2 = temp;
		}

		for (int r = r1; r <= r2; r++) {
			for (int c = c1; c <= c2; c++) {
				map[r][c] = val;
			}
		}
	}
}