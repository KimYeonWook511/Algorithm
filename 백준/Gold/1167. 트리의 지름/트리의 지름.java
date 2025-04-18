import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;

        Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static List<Node> tree[];
    static boolean chk[];
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        chk = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            tree[cur] = new ArrayList<>();

            while (true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) break;

                int w = Integer.parseInt(st.nextToken());

                tree[cur].add(new Node(next, w));
            }
        }

        dfs(1);

        System.out.println(result);

        br.close();
    }

    static int dfs(int cur) {
        chk[cur] = true;

        int max = 0;
        for (Node next : tree[cur]) {
            if (chk[next.i]) continue;

            int val = next.w + dfs(next.i);
            result = Math.max(result, max + val);
            max = Math.max(max, val);
        }

        return max;
    }
}