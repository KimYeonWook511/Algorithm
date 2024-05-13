import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        double d;

        Node(int idx, double d) {
            this.idx = idx;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        double arr[][] = new double[n][2];
        double graph[][] = new double[n][n];
        boolean chk[] = new boolean[n];
        double min[] = new double[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;

            for (int k = 0; k < i; k++) {
                graph[i][k] = graph[k][i] = Math.pow(arr[k][0] - x, 2) + Math.pow(arr[k][1] - y, 2);
            }
            
            min[i] = 2_000_001;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.d, o2.d);
            }
        });
        min[0] = 0;
        pq.offer(new Node(0, 0));

        int cnt = n;
        double sum = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (chk[cur.idx]) continue;

            chk[cur.idx] = true;
            sum += Math.sqrt(cur.d);
            if (--cnt == 0) break;

            for (int next = 0; next < n; next++) {
                if (chk[next]) continue;
                if (min[next] <= graph[cur.idx][next]) continue;
                
                min[next] = graph[cur.idx][next];
                pq.offer(new Node(next, min[next]));
            }
        }

        System.out.println(String.format("%.2f", sum));

        br.close();
    }
}