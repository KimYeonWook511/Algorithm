import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> graph[];
	static int matched[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		matched = new int[N + 1];
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			if (dfs(i)) {
				answer++;
			}
		}

		System.out.println(answer);

		br.close();
	}

	static boolean dfs(int cur) {
		if (visited[cur]) return false;
		visited[cur] = true;

		for (int laptop : graph[cur]) {
			if (matched[laptop] == 0 || dfs(matched[laptop])) {
				matched[laptop] = cur;
				return true;
			}
		}
		return false;
	}
}