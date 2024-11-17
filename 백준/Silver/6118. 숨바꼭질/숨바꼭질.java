import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, w;

        Node (int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean chk[] = new boolean[N + 1];
        int num = Integer.MAX_VALUE;
        int dist = 0;
        int cnt = 0;

        deque.offer(new Node(1, 0));
        chk[1] = true;

        Node cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur.w == dist) {
                num = Math.min(num, cur.idx);
                cnt++;

            } else if (cur.w > dist) {
                num = cur.idx;
                dist = cur.w;
                cnt = 1;
            }

            for (int next : graph[cur.idx]) {
                if (chk[next]) continue;

                deque.offer(new Node(next, cur.w + 1));
                chk[next] = true;
            }
        }

        System.out.println(num + " " + dist + " " + cnt);

        br.close();
    }
}