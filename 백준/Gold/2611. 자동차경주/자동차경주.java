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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node> graph[] = new ArrayList[N + 1]; // 역방향으로
        int indegree[] = new int[N + 1];
        int maxW[] = new int[N + 1];
        int tracking[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 역추적
            graph[q].add(new Node(p, r));
            indegree[p]++;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(1, 0));

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.i == 1 && cur.w != 0) break;

            for (Node next : graph[cur.i]) {
                int val = cur.w + next.w;
                if (val > maxW[next.i]) {
                    maxW[next.i] = val;
                    tracking[next.i] = cur.i;
                }

                if (--indegree[next.i] == 0) deque.offer(new Node(next.i, maxW[next.i]));
            }
        }

        StringBuilder sb = new StringBuilder().append(maxW[1]).append("\n");
        int trackingIndex = 1;
        while (true) {
            sb.append(trackingIndex).append(" ");
            trackingIndex = tracking[trackingIndex];

            if (trackingIndex == 1) break;
        }
        sb.append("1");

        System.out.println(sb);

        br.close();
    }
}