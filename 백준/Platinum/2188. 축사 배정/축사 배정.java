import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean visited[];
    static int matched[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            for (int s = 0; s < S; s++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        matched = new int[M + 1];
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

        for (int next : graph[cur]) {
            if (matched[next] == 0 || dfs(matched[next])) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }
}