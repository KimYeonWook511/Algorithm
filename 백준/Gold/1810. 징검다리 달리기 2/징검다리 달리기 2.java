import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;
        double w;

        Node (int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        // x,y 를 Pair로 한 Set<Pair>도 가능 -> 배열이 아니여서 좀 더 메모리 절약 가능해 보임 (다만 좀 더 느릴 수도)
        // Set<Pair>는 contains를 확인하기 위해 new를 계속 하면서 힙메모리가 오히려 낭비될 수도 있음
        Set<Integer> graph[] = new Set[1_000_001];
        Map<Integer, Double> dist[] = new Map[1_000_001];
        Set<Integer> visited[] = new Set[1_000_001];
        for (int i = 0; i <= 1_000_000; i++) {
            graph[i] = new HashSet<>();
            dist[i] = new HashMap<>();
            visited[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.w, o2.w);
            }
        });
        pq.offer(new Node(0, 0, 0.0));
        dist[0].put(0, 0.0);

        int answer = -1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.x].contains(cur.y)) continue;
            visited[cur.x].add(cur.y);

            if (cur.y == F) {
                answer = (int)Math.round(cur.w);
                break;
            }

            for (int nx = cur.x - 2; nx <= cur.x + 2; nx++) {
                for (int ny = cur.y - 2; ny <= cur.y + 2; ny++) {
                    if (nx < 0 || ny < 0 || nx > 1_000_000 || ny > F) continue;
                    if (!graph[nx].contains(ny)) continue;

                    double nw = cur.w + Math.sqrt(((cur.x - nx) * (cur.x - nx)) + ((cur.y - ny) * (cur.y - ny)));
                    if (dist[nx].getOrDefault(ny, Double.MAX_VALUE) > nw) {
                        pq.offer(new Node(nx, ny, nw));
                        dist[nx].put(ny, nw);
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}