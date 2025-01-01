import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean chk[];
    static int result[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        chk = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            result[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        func(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int i, int depth) {
        result[i] = depth;
        chk[i] = true;

        for (int next : graph[i]) {
            if (chk[next]) continue;

            func(next, depth + 1);
        }
    }
}