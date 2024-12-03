import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> graph[] = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int run = 0; run < m; run++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		Deque<int[]> deque = new ArrayDeque<>();
		boolean chk[] = new boolean[n + 1];

		deque.offer(new int[]{a, 0});
		chk[a] = true;

		int result = -1;
		int cur[];
		while (!deque.isEmpty()) {
			cur = deque.poll();

			if (cur[0] == b) {
				result = cur[1];
				break;
			}

			for (int next : graph[cur[0]]) {
				if (chk[next]) continue;

				deque.offer(new int[]{next, cur[1] + 1});
				chk[next] = true;
			}
		}

		System.out.println(result);

        br.close();
    }
}