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

    static int N, M;
    static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int bfs(int a, int b) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean chk[] = new boolean[N + 1];
        deque.offer(new Node(a, 0));
        chk[a] = true;

        int result = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.i == b) {
                result = cur.w;
                break;
            }

            for (Node next : graph[cur.i]) {
                if (chk[next.i]) continue;

                deque.offer(new Node(next.i, cur.w + next.w));
                chk[next.i] = true;
            }
        }

        return result;
    }
}