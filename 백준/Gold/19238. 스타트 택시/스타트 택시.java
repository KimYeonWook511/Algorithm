import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;
		int L;

		Node (int r, int c, int L) {
			this.r = r;
			this.c = c;
			this.L = L;
		}
	}

	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int N, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {
				map[r][c] = -Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		Node start = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, L);

		int destinations[][] = new int[M + 1][2];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int endR = Integer.parseInt(st.nextToken()) - 1;
			int endC = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = i;
			destinations[i][0] = endR;
			destinations[i][1] = endC;
		}

		for (int t = 0; t < M; t++) {
			Node searchNode = searchCustomer(start);
			if (searchNode == null) {
				start.L = -1;
				break;
			}

			int endR = destinations[map[searchNode.r][searchNode.c]][0];
			int endC = destinations[map[searchNode.r][searchNode.c]][1];
			Node nextStart = move(searchNode, endR, endC);
			if (nextStart == null) {
				start.L = -1;
				break;
			}

			start = nextStart;
			map[searchNode.r][searchNode.c] = 0;
		}

		System.out.println(start.L);

		br.close();
	}

	static Node searchCustomer(Node start) {
		Deque<Node> deque = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		deque.offer(start);
		visited[start.r][start.c] = true;

		int dist = Integer.MAX_VALUE;
		Node ret = null;
		while (!deque.isEmpty()) {
			Node cur = deque.poll();

			if (start.L - cur.L > dist) {
				break;
			}

			if (map[cur.r][cur.c] > 0) {
				if (ret == null || cur.r < ret.r || (cur.r == ret.r && cur.c < ret.c)) {
					ret = cur;
					dist = start.L - cur.L;
				}
				continue;
			}

			if (cur.L > 0) {
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (nr < 0 || nc < 0) continue;
					if (nr >= N || nc >= N) continue;
					if (map[nr][nc] == -1) continue;
					if (visited[nr][nc]) continue;

					deque.offer(new Node(nr, nc, cur.L - 1));
					visited[nr][nc] = true;
				}
			}
		}

		return ret;
	}

	static Node move(Node start, int endR, int endC) {
		Deque<Node> deque = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		deque.offer(start);
		visited[start.r][start.c] = true;

		Node ret = null;
		while (!deque.isEmpty()) {
			Node cur = deque.poll();

			if (cur.r == endR && cur.c == endC) {
				// 연료 충전
				cur.L += 2 * (start.L - cur.L);
				ret = cur;
				break;
			}

			if (cur.L > 0) {
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (nr < 0 || nc < 0) continue;
					if (nr >= N || nc >= N) continue;
					if (map[nr][nc] == -1) continue;
					if (visited[nr][nc]) continue;

					deque.offer(new Node(nr, nc, cur.L - 1));
					visited[nr][nc] = true;
				}
			}
		}

		return ret;
	}
}