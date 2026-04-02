import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int i, dist;

		Node(int i, int dist) {
			this.i = i;
			this.dist = dist;
		}
	}

	static class Case {
		int i;
		long sum; // 비용 합
		int min; // 최소 주유소 가격

		Case(int i, long sum, int min) {
			this.i = i;
			this.sum = sum;
			this.min = min;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Node> graph[] = new List[N + 1];
		long minSum[][] = new long[N + 1][2501];

		int costL[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			costL[i] = Integer.parseInt(st.nextToken());

			graph[i] = new ArrayList<>();
			for (int s = 1; s <= 2500; s++) {
				minSum[i][s] = Long.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, dist));
			graph[b].add(new Node(a, dist));
		}

		PriorityQueue<Case> pq = new PriorityQueue<>(new Comparator<Case>() {
			@Override
			public int compare(Case o1, Case o2) {
				return Long.compare(o1.sum, o2.sum);
			}
		});
		boolean visited[][] = new boolean[N + 1][2501];
		pq.offer(new Case(1, 0L, costL[1]));
		minSum[1][costL[1]] = 0L;

		long answer = 0;
		while (!pq.isEmpty()) {
			Case cur = pq.poll();

			if (cur.i == N) {
				answer = cur.sum;
				break;
			}

			if (visited[cur.i][cur.min]) continue;
			visited[cur.i][cur.min] = true;

			for (Node next : graph[cur.i]) {
				int nextMin = Math.min(cur.min, costL[next.i]);
				if (visited[next.i][nextMin]) continue;
				if (minSum[next.i][nextMin] <= cur.sum + (cur.min * next.dist)) continue;

				minSum[next.i][nextMin] = cur.sum + (cur.min * next.dist);
				pq.offer(new Case(next.i, minSum[next.i][nextMin], nextMin));
			}
		}

		System.out.println(answer);

		br.close();
	}
}