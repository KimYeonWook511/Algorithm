import java.io.*;
import java.util.*;

public class Main {
	static int parent[] = new int[1_000_001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 1; i <= 1_000_000; i++) {
			parent[i] = -1;
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			
			if (cmd == 'I') {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
				
			} else {
				int c = Integer.parseInt(st.nextToken());
				
				sb.append(-parent[find(c)]).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static int find(int a) {
		if (parent[a] < 0) return a;
		
		return parent[a] = find(parent[a]); 
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		
		if (parent[a] < parent[b]) {
			parent[a] += parent[b];
			parent[b] = a;
		} else {
			parent[b] += parent[a];
			parent[a] = b;
		}
	}
}