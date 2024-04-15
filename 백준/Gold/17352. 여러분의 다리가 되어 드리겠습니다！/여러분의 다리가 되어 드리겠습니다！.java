import java.io.*;
import java.util.*;

public class Main {
	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = N - 2; i > 0; i--) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(x, y);
		}
		
		for (int i = 1; i <= N; i++) {
			if (find(i) == i) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
}