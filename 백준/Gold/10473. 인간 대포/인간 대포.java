import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        double x, y;

        Point (double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        int i;
        double t;

        Node (int i, double t) {
            this.i = i;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Point start = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point end = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        int n = Integer.parseInt(br.readLine());
        List<Node> graph[] = new List[n + 2];
        double minT[] = new double[n + 2];
        for (int i = 0; i <= n + 1; i++) {
            graph[i] = new ArrayList<>();
            minT[i] = Double.MAX_VALUE;
        }

        // 시작점 -> 도착점
        double dist = getDistance(start, end);
        double time = dist / 5.0;
        graph[0].add(new Node(n + 1, time));

        Point arr[] = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

            // 시작점 -> i
            dist = getDistance(start, arr[i]);
            time = dist / 5.0; // 시작점에선 대포x
            graph[0].add(new Node(i, time));

            // i -> 도착점
            dist = getDistance(end, arr[i]);
            time = getTime(dist);
            graph[i].add(new Node(n + 1, time));

            // i <-> k (대포 간 이동)
            for (int k = 1; k < i; k++) {
                dist = getDistance(arr[k], arr[i]);
                time = getTime(dist);
                graph[i].add(new Node(k, time));
                graph[k].add(new Node(i, time));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.t, o2.t);
            }
        });
        boolean visited[] = new boolean[n + 2];
        pq.offer(new Node(0, 0));
        minT[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == n + 1) {
                break;
            }

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (minT[next.i] <= cur.t + next.t) continue;

                pq.offer(new Node(next.i, cur.t + next.t));
                minT[next.i] = cur.t + next.t;
            }
        }

        System.out.println(minT[n + 1]);

        br.close();
    }

    static double getDistance(Point p1, Point p2) {
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    static double getTime(double dist) {
        double walk = dist / 5.0;
        double cannon = 2.0 + Math.abs(dist - 50.0) / 5.0;
        return Math.min(walk, cannon);
    }
}