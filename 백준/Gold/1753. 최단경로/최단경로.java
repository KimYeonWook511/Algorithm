import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int V, E, K, u, v, w, dist[];
	static List<List<Node>> graph = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return Integer.compare(o1.w, o2.w);
		}
	});
	static Node cur;
	static boolean chk[];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		dist = new int[V + 1];
		chk = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int run = 0; run < E; run++) {
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}

		dist[K] = 0;
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			cur = pq.poll();
			
			if (dist[cur.v] < cur.w) continue;
			if (chk[cur.v]) continue;

			chk[cur.v] = true;

			for (Node next : graph.get(cur.v)) {
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