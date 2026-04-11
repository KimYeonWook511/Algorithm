import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Point points[] = new Point[n + 2];
        points[0] = new Point(0, 0);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        points[n + 1] = new Point(10000, 10000);

        int left = 0;
        int right = 2000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(points, mid) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

        br.close();
    }

    static int bfs(Point points[], int mid) {
        int maxDist = mid * 10;
        int maxDistPow = maxDist * maxDist;

        Deque<Integer> deque = new ArrayDeque<>();
        int dist[] = new int[points.length];
        Arrays.fill(dist, -1);
        deque.offer(0);
        dist[0] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == points.length - 1) {
                return dist[cur] - 1;
            }

            for (int next = 1; next < points.length; next++) {
                if (dist[next] != -1) continue;

                int dx = points[cur].x - points[next].x;
                int dy = points[cur].y - points[next].y;
                if (dx * dx + dy * dy <= maxDistPow) {
                    deque.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}