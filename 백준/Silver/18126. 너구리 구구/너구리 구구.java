import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        long w;

        Node (int i, long w) {
            this.i = i;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node> graph[] = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[N + 1];
        deque.offer(new Node(1, 0));
        visited[1] = true;

        long answer = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            answer = Math.max(answer, cur.w);

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;

                visited[next.i] = true;
                deque.offer(new Node(next.i, cur.w + next.w));
            }
        }

        System.out.println(answer);

        br.close();
    }
}