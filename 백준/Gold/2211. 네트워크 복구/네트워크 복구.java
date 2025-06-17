import java.io.*;
import java.util.*;

public class Main {
    static class Computer {
        int i, w;

        Computer (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static class Node extends Computer {
        int pre;

        Node (int i, int w, int pre) {
            super(i, w);
            this.pre = pre;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static List<Integer> path[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Computer> graph[] = new ArrayList[N + 1];
        path = new ArrayList[N + 1];
        int minW[] = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Computer(B, C));
            graph[B].add(new Computer(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];

        pq.offer(new Node(1, 0, 0));
        minW[1] = 0;

        int cnt = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;
            path[cur.pre].add(cur.i);

            if (++cnt == N) {
                sb.append(N - 1).append("\n");
                dfs(1);
                break;
            }

            for (Computer next : graph[cur.i]) {
                if (minW[next.i] <= cur.w + next.w) continue;

                minW[next.i] = cur.w + next.w;
                pq.offer(new Node(next.i, cur.w + next.w, cur.i));
            }
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int cur) {
        for (int next : path[cur]) {
            sb.append(cur).append(" ").append(next).append("\n");
            dfs(next);
        }
    }
}