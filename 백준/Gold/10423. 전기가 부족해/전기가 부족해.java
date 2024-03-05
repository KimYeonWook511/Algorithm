import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int u, v, w;
		
		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			parent[Integer.parseInt(st.nextToken())] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(u, v, w));
		}
		
		int cnt = N - K;
		int sum = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (!union(cur.u, cur.v)) continue;
			
			sum += cur.w;
			
			if (--cnt == 0) break;
		}
		
		System.out.println(sum);
		
		br.close();
	}
	
	static int find(int x) {
		if (parent[x] == 0) return 0;
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
		
		return true;
	}
}