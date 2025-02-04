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
    static int max[];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[n + 1];
        max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[p].add(new Node(c, w));
        }

        func(new Node(1, 0));

        System.out.println(result);

        br.close();
    }

    static void func(Node cur) {
        for (Node next : tree[cur.i]) {
            func(next);

            result = Math.max(result, max[cur.i] + max[next.i] + next.w);
            max[cur.i] = Math.max(max[cur.i], max[next.i] + next.w);
        }
    }
}