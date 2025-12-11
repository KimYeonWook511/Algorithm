import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[]; // tree
    static int arr[];
    static int dp[][];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new List[N + 1]; // tree
        arr = new int[N + 1];
        dp = new int[N + 1][2]; // 0: 우수, 1: 우수x

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

        br.close();
    }

    static void dfs(int cur) {
        visited[cur] = true;

        dp[cur][0] = arr[cur];

        for (int next : graph[cur]) {
            if (visited[next]) continue;

            dfs(next);

            // 현재가 우수 마을인 경우
            dp[cur][0] += dp[next][1];
            // 현재가 우수 마을이 아닌 경우
            dp[cur][1] += Math.max(dp[next][0], dp[next][1]); // xo, xx인 경우임 -> 시작노드랑 마지막 노드는 xx로 오면 안 되지만 max값이 들어가기 때문에 해당 경우가 걸러짐
        }
    }
}