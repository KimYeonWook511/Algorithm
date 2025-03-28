import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int i, w;
		
		Node (int i, int w) {
			this.i = i;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Node> graph[] = new ArrayList[N + 1];
		int minW[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			minW[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
		pq.offer(new Node(1, 0));
		minW[1] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.i == N) {
				System.out.println(cur.w);
				break;
			}
			
			for (Node next : graph[cur.i]) {
				if (minW[next.i] <= cur.w + next.w) continue;
				
				minW[next.i]= cur.w + next.w;
				pq.offer(new Node(next.i, cur.w + next.w));
			}
		}

		br.close();
	}
}