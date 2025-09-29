import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        double w;

        Node (int i, double w) {
            this.i = i;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double M = Double.parseDouble(br.readLine());
        double MM = M * M;

        int arr[][] = new int[N + 1][2];
        List<Node> graph[] = new ArrayList[N + 1];
        double minW[] = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;

            graph[i] = new ArrayList<>();
            minW[i] = Double.MAX_VALUE;
        }

        for (int i = 1; i < N; i++) {
            for (int k = i + 1; k <= N; k++) {
                long x = arr[i][0] - arr[k][0];
                long y = arr[i][1] - arr[k][1];
                long val = (x * x) + (y * y);

                if (val > MM) continue;
                double dist = Math.sqrt(val);

                graph[i].add(new Node(k, dist));
                graph[k].add(new Node(i, dist));
            }
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, 0));
            graph[b].add(new Node(a, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];
        pq.offer(new Node(1, 0));
        minW[1] = 0;

        int result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            if (cur.i == N) {
                result = (int)(cur.w * 1000);   
                break;
            }

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;
                if (minW[next.i] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w));
                minW[next.i] = cur.w + next.w;
            }
        }

        System.out.println(result);

        br.close();
    }
}