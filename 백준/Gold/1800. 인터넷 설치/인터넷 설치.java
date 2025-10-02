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
    static int N, P, K;
    static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        int left = 0;
        int right = 1_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (func(mid)) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left > 1_000_000 ? -1 : left);

        br.close();
    }

    static boolean func(int mid) {
        Deque<Integer> deque = new ArrayDeque<>();
        int chk[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            chk[i] = Integer.MAX_VALUE;
        }
        deque.offer(1);
        chk[1] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Node next : graph[cur]) {
                if (next.w <= mid) {
                    if (chk[next.i] <= chk[cur]) continue;

                    deque.offerFirst(next.i);
                    chk[next.i] = chk[cur];
                } else {
                    if (chk[cur] + 1 > K) continue;
                    if (chk[next.i] <= chk[cur] + 1) continue;

                    deque.offerLast(next.i);
                    chk[next.i] = chk[cur] + 1;
                }
            }
        }

        return chk[N] != Integer.MAX_VALUE;
    }
}