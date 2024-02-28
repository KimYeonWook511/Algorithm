import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<Node> graph[] = new ArrayList[V + 1];
		int dist[] = new int[V + 1];
		boolean chk[] = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int run = 0; run < E; run++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
		
		dist[K] = 0;
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.v] < cur.w) continue;
			if (chk[cur.v]) continue;

			chk[cur.v] = true;

			for (Node next : graph[cur.v]) {
				if (dist[next.v] <= dist[cur.v] + next.w) continue;

				dist[next.v] = dist[cur.v] + next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}

		System.out.println(sb);
		
		br.close();
	}
}