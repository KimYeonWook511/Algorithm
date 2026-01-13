import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int i;
		long w;

		Node (int i, long w) {
			this.i = i;
			this.w = w;
		}
	}
	static List<Node> graph[];
	static int h[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		h = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			h[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long n = Long.parseLong(st.nextToken());

			graph[a].add(new Node(b, n));
			graph[b].add(new Node(a, n));
		}

		// 집 -> 목표
		long maxVal1[] = new long[N + 1];
		Arrays.fill(maxVal1, Long.MAX_VALUE);
		dijk(N, 1, maxVal1);

		// 학교 -> 목표
		long maxVal2[] = new long[N + 1];
		Arrays.fill(maxVal2, Long.MAX_VALUE);
		dijk(N, N, maxVal2);

		long answer = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (maxVal1[i] != Long.MAX_VALUE && maxVal2[i] != Long.MAX_VALUE) {
				answer = Math.max(answer, ((long)h[i] * E) - ((maxVal1[i] + maxVal2[i]) * D));
			}
		}

		System.out.println(answer == Long.MIN_VALUE ? "Impossible" : answer);

		br.close();
	}

	static void dijk(int N, int start, long dist[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Long.compare(o1.w, o2.w);
			}
		});
		boolean visited[] = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.i]) continue;
			visited[cur.i] = true;

			for (Node next : graph[cur.i]) {
				if (h[next.i] <= h[cur.i]) continue;
				if (dist[next.i] <= cur.w + next.w) continue;

				pq.offer(new Node(next.i, cur.w + next.w));
				dist[next.i] = cur.w + next.w;
			}
		}
	}
}