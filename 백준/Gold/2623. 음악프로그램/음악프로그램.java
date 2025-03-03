import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> graph[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int cnt[] = new int[N + 1];
		int total = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int pre = Integer.parseInt(st.nextToken());
			for (int k = 1; k < n; k++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[pre].add(temp);
				cnt[temp]++;
				total++;

				pre = temp;
			}
		}

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (cnt[i] != 0) continue;

			deque.offer(i);
		}

		while (!deque.isEmpty()) {
			int cur = deque.poll();
			sb.append(cur).append("\n");

			for (int next : graph[cur]) {
				total--;

				if (--cnt[next] != 0) continue;
				deque.offer(next);
			}
		}

		System.out.println(total != 0 ? 0 : sb);

        br.close();
	}
}