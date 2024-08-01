import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean chk[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        chk = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        func(0, 1);

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (chk[i]) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    static void func(int cnt, int i) {
        if (cnt == 2) return;

        for (int next : graph[i]) {
            chk[next] = true;
            func(cnt + 1, next);
        }
    }
}