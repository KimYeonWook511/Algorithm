import java.io.*;
import java.util.*;

public class Main {
	static int parent[], idx;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < T; run++) {
			int F = Integer.parseInt(br.readLine());
			
			parent = new int[F << 1];
			map = new HashMap<>();
			idx = 0;
			
			for (int i = (F << 1) - 1; i >= 0; i--) {
				parent[i] = -1;
			}
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!map.containsKey(a)) map.put(a, idx++);
				if (!map.containsKey(b)) map.put(b, idx++);
				
				int aIdx = map.get(a);
				int bIdx = map.get(b);
				
				sb.append(-union(aIdx, bIdx)).append("\n");
			}
		}
        
        System.out.println(sb);

		br.close();
	}
	
	static int find(int x) {
		if (parent[x] < 0) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return parent[x];
		
		parent[x] += parent[y];
		parent[y] = x;
		
		return parent[x];
	}
}