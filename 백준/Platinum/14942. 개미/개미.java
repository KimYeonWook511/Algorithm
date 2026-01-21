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

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n + 1];
        List<Node> graph[] = new List[n + 1]; // 트리 (굴을 타고 한 방에서 다른 방으로 갈 수 있는 경로는 항상 존재하며 유일하다 -> 사이클X)
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        int LOG = 1;
        while ((1 << LOG) <= (n - 1)) {
            LOG++;
        }
        int next[][] = new int[LOG][n + 1];
        int dist[][] = new int[LOG][n + 1];

        // 초기(k=0) 세팅
        // bfs = O(N + (N - 1)) = 2*O(N)
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(1, 0));
        next[0][1] = 1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            for (Node nextNode : graph[cur.i]) {
                if (next[0][nextNode.i] != 0) continue;

                next[0][nextNode.i] = cur.i;
                dist[0][nextNode.i] = nextNode.w;
                deque.offer(nextNode);
            }
        }

        // nlogn
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                next[k][v] = next[k - 1][next[k - 1][v]];
                dist[k][v] = dist[k - 1][v] + dist[k - 1][next[k - 1][v]];
            }
        }

        // nlogn
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= n; v++) {
            int cur = v;
            int energy = arr[v];
            for (int k = LOG - 1; k >= 0; k--) {
                if (energy - dist[k][cur] < 0) continue;

                energy -= dist[k][cur];
                cur = next[k][cur];
            }

            sb.append(cur).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}