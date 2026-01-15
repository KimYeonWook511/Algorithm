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
        matched = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            graph[i] = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                int work = Integer.parseInt(st.nextToken());
                graph[i].add(work);
            }
        }

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

        for (int work : graph[cur]) {
            if (matched[work] == 0 || dfs(matched[work])) {
                matched[work] = cur;
                return true;
            }
        }
        return false;
    }
}