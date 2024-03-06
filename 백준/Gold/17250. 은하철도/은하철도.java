import java.io.*;
import java.util.*;

public class Main {
	static int cnt[], parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		cnt = new int[N + 1];
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(br.readLine());
			parent[i] = i;
		}
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			
			sb.append(cnt[union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return x;
		
		if (x < y) {
			cnt[x] += cnt[y];
			cnt[y] = 0;
			
			return parent[y] = x;
		}
		
		cnt[y] += cnt[x];
		cnt[x] = 0;
		
		return parent[x] = y;
	}
}