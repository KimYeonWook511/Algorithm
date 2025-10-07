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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		List<Node> graph[] = new ArrayList[N + 1];
		long minW[] = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			minW[i] = Long.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}

		int left = 1;
		int right = (int)1e9;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (dijk(N, A, B, C, graph, mid)) right = mid - 1;
			else left = mid + 1;
		}

		// (500,000 + 100,000)log500,000 => 600,000 * 19 => 11,400,000
		// (중복 offer의 경우 (E+V)logE로 계산 되는데, 보통 (E+V)logV로 표시한다곤 함)
		// log(1e9) => 30
		System.out.println(left > 1e9 ? -1 : left);

		br.close();
	}

	static boolean dijk(int N, int A, int B, long C, List<Node> graph[], int mid) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Long.compare(o1.w, o2.w);
			}
		});
		boolean visited[] = new boolean[N + 1];
		long minW[] = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			minW[i] = Long.MAX_VALUE;
		}

		pq.offer(new Node(A, 0));
		minW[A] = 0;

		boolean flag = false;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.i]) continue;
			visited[cur.i] = true;

			if (cur.i == B) {
				flag = true;
				break;
			}

			for (Node next : graph[cur.i]) {
				if (visited[next.i]) continue;
				if (next.w > mid) continue;
				if (minW[next.i] <= cur.w + next.w) continue;
				if (cur.w + next.w > C) continue;

				pq.offer(new Node(next.i, cur.w + next.w));
				minW[next.i] = cur.w + next.w;
			}
		}

		return flag;
	}
}
