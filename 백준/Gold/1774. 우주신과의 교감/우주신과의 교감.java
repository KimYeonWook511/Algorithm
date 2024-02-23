import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int idx;
		double w;
		
		Node (int idx, double w) {
			this.idx = idx;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int node[][] = new int[N][2];
		double graph[][] = new double[N][N];
		boolean chk[] = new boolean[N];
		double minW[] = new double[N];
		
		for (int run = 0; run < N; run++) {
			st = new StringTokenizer(br.readLine());
			
			node[run][0] = Integer.parseInt(st.nextToken());
			node[run][1] = Integer.parseInt(st.nextToken());
			
			minW[run] = Integer.MAX_VALUE;
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				graph[x][y] = graph[y][x] = Math.sqrt(Math.pow(Math.abs(node[x][0] - node[y][0]), 2) + Math.pow(Math.abs(node[x][1] - node[y][1]), 2));
			}
		}

		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			graph[a][b] = graph[b][a] = 0;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.w, o2.w);
			}
		});
		
		minW[0] = 0;
		pq.offer(new Node(0, 0));
		
		double sum = 0;
		int cnt = N;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (chk[cur.idx]) continue;
			
			chk[cur.idx] = true; 
			sum += cur.w;
			
			if (--cnt == 0) break;
			
			for (int next = 0; next < N; next++) {
				if (chk[next]) continue;
				if (graph[cur.idx][next] >= minW[next]) continue;
				
				minW[next] = graph[cur.idx][next];
				pq.offer(new Node(next, minW[next]));
			}
		}
		
		System.out.println(String.format("%.2f", sum));
		
		br.close();
	}
}