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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[n + 1];
        PriorityQueue<Integer> maxDist[] = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            maxDist[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        // deque으로도 될거 같음 -> 다만 k보다 큰 거리가 maxDist에 들어가서 불필요한 정렬이 계속 일어날 수도 있음
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        pq.offer(new Node(1, 0));
        maxDist[1].offer(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph[cur.i]) {
                int nextW = cur.w + next.w;

                if (maxDist[next.i].size() < k) {
                    pq.offer(new Node(next.i, nextW));
                    maxDist[next.i].offer(nextW);
                } else if (maxDist[next.i].peek() > nextW) { // maxDist[next.i].size > 0 보장
                    pq.offer(new Node(next.i, nextW));
                    maxDist[next.i].poll();
                    maxDist[next.i].offer(nextW);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(maxDist[i].size() < k ? "-1" : maxDist[i].peek()).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}