import java.io.*;
import java.util.*;

public class Main {
	
	static int parent[];
	static List<Integer> graph[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			graph[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (find(i) == 1) cnt++;
		}
		
		
		System.out.println(cnt);
		
		br.close();
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x > y) parent[x] = y;
		else parent[y] = x;
	}
}