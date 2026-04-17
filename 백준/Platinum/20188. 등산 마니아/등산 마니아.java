import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean visited[];
    static long depthSum;
    static long lcaSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, 0);

        // 각 노드마다 쌍만큼 depth가 반복됨.
        // 즉 전체 노드의 depth 합을 구하고 쌍이 될 수 있는 경우인 N-1을 곱하면 전체 쌍의 depth 합을 구할 수 있음
        // 여기서 lca까지 depth가 중복되기 때문에 이것을 lcaSum을 구하여 빼줌
        long answer = depthSum * (N - 1) - lcaSum;
        System.out.println(answer);

        br.close();
    }

    static long dfs(int cur, int depth) {
        visited[cur] = true;
        depthSum += depth;

        long pairCount = 0;
        long childSum = 0;
        for (int next : graph[cur]) {
            if (visited[next]) continue;

            long childCount = dfs(next, depth + 1);

            pairCount += childSum * childCount + childCount;
            childSum += childCount;
        }

        lcaSum += pairCount * depth;

        return childSum + 1;
    }
}