import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        boolean isUphill;

        Node (int i, boolean isUphill) {
            this.i = i;
            this.isUphill = isUphill;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = -1; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean isUphill = st.nextToken().equals("0");

            graph[A].add(new Node(B, isUphill));
            graph[B].add(new Node(A, isUphill));
        }

        Deque<Node> bestDeque = new ArrayDeque<>();
        boolean bestVisited[] = new boolean[N + 1];
        bestDeque.offer(new Node(0, false));
        int bestK = 0;
        int bestCnt = N + 1;
        while (!bestDeque.isEmpty()) {
            Node cur = bestDeque.poll();

            if (bestVisited[cur.i]) continue;
            bestVisited[cur.i] = true;

            if (cur.isUphill) bestK++;
            if (--bestCnt == 0) break;

            for (Node next : graph[cur.i]) {
                if (bestVisited[next.i]) continue;

                if (next.isUphill) {
                    bestDeque.offerLast(next);
                } else {
                    bestDeque.offerFirst(next);
                }
            }
        }

        Deque<Node> worstDeque = new ArrayDeque<>();
        boolean worstVisited[] = new boolean[N + 1];
        worstDeque.offer(new Node(0, false));
        int worstK = 0;
        int worstCnt = N + 1;
        while (!worstDeque.isEmpty()) {
            Node cur = worstDeque.poll();

            if (worstVisited[cur.i]) continue;
            worstVisited[cur.i] = true;

            if (cur.isUphill) worstK++;
            if (--worstCnt == 0) break;

            for (Node next : graph[cur.i]) {
                if (worstVisited[next.i]) continue;

                if (next.isUphill) {
                    worstDeque.offerFirst(next);
                } else {
                    worstDeque.offerLast(next);
                }
            }
        }

        System.out.println((worstK * worstK) - (bestK * bestK));

        br.close();
    }
}