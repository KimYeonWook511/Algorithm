import java.io.*;
import java.util.*;

public class Main {
	static class P {
		int a, b, t;
		
		P (int a, int b, int t) {
			this.a = a;
			this.b = b;
			this.t = t;
		}
	}
	
	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		PriorityQueue<P> pq = new PriorityQueue<>(new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return Integer.compare(o1.t, o2.t);
			}
		});
		
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			pq.offer(new P(A, B, C));
		}
		
		int cnt = 0;
		int sum = 0;
		
		while (!pq.isEmpty()) {
			P cur = pq.poll();
			
			if (!union(cur.a, cur.b)) continue;
			
			sum += cur.t;
			sum += t * cnt;
			if (++cnt == N - 1) break;
		}
		
		System.out.println(sum);
		
		br.close();
	}
	
	static int find(int x) {
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