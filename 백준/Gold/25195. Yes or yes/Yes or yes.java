import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> graph[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		boolean notLast[] = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			notLast[u] = true;
		}

		boolean fan[] = new boolean[N + 1];
		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < S; i++) {
			fan[Integer.parseInt(st.nextToken())] = true;
		}

		Deque<Integer> deque = new ArrayDeque<>();

		if (!fan[1]) deque.offer(1);

		boolean flag = false;

		while (!deque.isEmpty()) {
			int cur = deque.poll();

			if (!notLast[cur]) {
				flag = true;
				break;
			}

			for (int next : graph[cur]) {
				if (fan[next]) continue;

				deque.offer(next);
			}
		}

		System.out.println(flag ? "yes" : "Yes");

		br.close();
	}
}