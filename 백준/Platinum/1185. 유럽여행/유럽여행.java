import java.io.*;
import java.util.*;

public class Main {
	// prim
	static class Node {
		int i, w;

		Node(int i, int w) {
			this.i = i;
			this.w = w;
		}
	}

	// kruskal
	static class Edge {
		int a, b, w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	static int parents[];
	static int ranks[];

	public static void main(String[] args) throws Exception {
		prim(); // E: 2*P, V: N -> O(ElogV)
		// kruskal(); // E: P, V:N -> O(ElogE)
		// 크루스칼이 더 빠를 것으로 예상
	}

	static void prim() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		List<Node> graph[] = new List[N + 1];
		int dist[] = new int[N + 1];

		int start = 0;
		int minValue = Integer.MAX_VALUE;
		int nodeValue[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nodeValue[i] = Integer.parseInt(br.readLine());

			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
			if (nodeValue[i] < minValue) {
				minValue = nodeValue[i];
				start = i;
			}
		}

		for (int p = 0; p < P; p++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int w = 2 * L + nodeValue[S] + nodeValue[E];
			graph[S].add(new Node(E, w));
			graph[E].add(new Node(S, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
		boolean visited[] = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		int answer = nodeValue[start];
		int count = N;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.i]) continue;
			visited[cur.i] = true;
			answer += cur.w;

			if (--count == 0) break;

			for (Node next : graph[cur.i]) {
				if (dist[next.i] <= next.w) continue;

				pq.offer(next);
				dist[next.i] = next.w;
			}
		}

		System.out.println(answer);

		br.close();
	}

	static void kruskal() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		ranks = new int[N + 1];

		int start = 0;
		int minValue = Integer.MAX_VALUE;
		int nodeValue[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			nodeValue[i] = Integer.parseInt(br.readLine());

			if (nodeValue[i] < minValue) {
				minValue = nodeValue[i];
				start = i;
			}
		}

		Edge edges[] = new Edge[P];
		for (int p = 0; p < P; p++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			edges[p] = new Edge(S, E, 2 * L + nodeValue[S] + nodeValue[E]);
		}

		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		int answer = minValue;
		int count = N - 1;
		for (int i = 0; i < P; i++) {
			Edge edge = edges[i];

			if (union(edge.a, edge.b)) {
				answer += edge.w;
				if (--count == 0) break;
			}
		}

		System.out.println(answer);

		br.close();
	}

	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) return false;

		if (ranks[a] < ranks[b]) {
			parents[a] = b;
		} else if (ranks[a] > ranks[b]) {
			parents[b] = a;
		} else {
			parents[b] = a;
			ranks[a]++;
		}
		return true;
	}
}