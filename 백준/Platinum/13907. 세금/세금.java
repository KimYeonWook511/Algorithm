import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;
        int cnt;

        Node (int i, int w, int cnt) {
            this.i = i;
            this.w = w;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[N + 1];
        int minW[][] = new int[N + 1][N];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();

            for (int cnt = 0; cnt < N; cnt++) {
                minW[i][cnt] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w, 0));
            graph[b].add(new Node(a, w, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[][] = new boolean[N + 1][N];
        pq.offer(new Node(S, 0, 0));
        minW[S][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i][cur.cnt]) continue;
            visited[cur.i][cur.cnt] = true;

            if (cur.cnt == N - 1) continue;

            for (Node next : graph[cur.i]) {
                if (minW[next.i][cur.cnt + 1] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w, cur.cnt + 1));
                minW[next.i][cur.cnt + 1] = cur.w + next.w;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(cal(minW[D], 0)).append("\n");
        for (int k = 0; k < K; k++) {
            int val = Integer.parseInt(br.readLine());
            sb.append(cal(minW[D], val)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int cal(int minW[], int val) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minW.length; i++) {
            if (minW[i] != Integer.MAX_VALUE) {
                minW[i] += (i * val);
                min = Math.min(min, minW[i]);
            }
        }
        return min;
    }
}