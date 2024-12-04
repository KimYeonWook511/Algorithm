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

        List<Node> graph[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> deque = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -Integer.compare(o1.w, o2.w);
            }
        });
        int chk[] = new int[N + 1];

        deque.offer(new Node(start, Integer.MAX_VALUE));
        chk[start] = Integer.MAX_VALUE;

        Node cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur.w < chk[cur.idx]) continue;

            if (cur.idx == end) {
                System.out.println(cur.w);
                break;
            }

            for (Node next : graph[cur.idx]) {
                int min = Math.min(next.w, cur.w);

                if (chk[next.idx] >= min) continue;

                deque.offer(new Node(next.idx, min));
                chk[next.idx] = min;
            }
        }

        br.close();
    }
}