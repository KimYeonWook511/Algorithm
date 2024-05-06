import java.io.*;
import java.util.*;

public class Main {
	static int parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int n, k, m;

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			parent = new int[n];
			for (int i = 1; i < n; i++) {
				parent[i] = i;
			}

			k = Integer.parseInt(br.readLine());
			for (int run = 0; run < k; run++) {
				st = new StringTokenizer(br.readLine());

				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			sb.append("Scenario ").append(tc).append(":\n");
			
			m = Integer.parseInt(br.readLine());
			for (int run = 0; run < m; run++) {
				st = new StringTokenizer(br.readLine());

				sb.append(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
			}
			sb.append("\n");
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