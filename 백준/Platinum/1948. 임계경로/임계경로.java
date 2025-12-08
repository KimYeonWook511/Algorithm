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

        br.readLine(); // n -> 의미 없는거 같음
        int m = Integer.parseInt(br.readLine());

        List<Node> graph[] = new List[10001]; // 노드의 번호의 끝이 n이 아닌 10000임
        int indegree[] = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            indegree[v]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        int maxDist[] = new int[10001];
        List<Integer> trackingGraph[] = new List[10001]; // 그냥 원래 graph를 뒤집어서 revGraph랑, revIndegree만들어서 전체 탐색해도 될듯
        trackingGraph[start] = new ArrayList<>();
        // int trackingIndegree[] = new int[10001]; // 사실상 trackingGraph.size
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Node next : graph[cur]) {
                if (--indegree[next.i] == 0) { // 근데 dfs도 가능한거 아닌가?
                    deque.offer(next.i);
                }

                if (maxDist[next.i] == maxDist[cur] + next.w) {
                    trackingGraph[next.i].add(cur);
                } else if (maxDist[next.i] < maxDist[cur] + next.w) {
                    maxDist[next.i] = maxDist[cur] + next.w;
                    trackingGraph[next.i] = new ArrayList<>(); // trackingGraph[next.i].clear();
                    trackingGraph[next.i].add(cur);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxDist[end]).append("\n");

        boolean visited[] = new boolean[10001];
        deque.offer(end);
        visited[end] = true;
        int cnt = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : trackingGraph[cur]) {
                cnt++;
                if (!visited[next]) {
                    deque.offer(next);
                    visited[next] = true;
                }
            }
        }
        sb.append(cnt);

        System.out.println(sb);

        br.close();
    }
}