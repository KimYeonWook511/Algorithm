import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, d;

        Node (int i, int d) {
            this.i = i;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        List<Node> graph[] = new ArrayList[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.d, o2.d);
            }
        });
        int minD[][] = new int[3][N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            minD[0][i] = Integer.MAX_VALUE;
            minD[1][i] = Integer.MAX_VALUE;
            minD[2][i] = Integer.MAX_VALUE;
        }

        int a, b, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        for (int i = 0; i < 3; i++) {
            pq.offer(new Node(arr[i], 0));
            minD[i][arr[i]] = 0;

            Node cur = null;
            while (!pq.isEmpty()) {
                cur = pq.poll();
                
                if (minD[i][cur.i] < cur.d) continue;

                for (Node next : graph[cur.i]) {
                    if (minD[i][next.i] <= cur.d + next.d) continue;

                    minD[i][next.i] = cur.d + next.d;
                    pq.offer(new Node(next.i, cur.d + next.d));
                }
            }
        }

        int result = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int val = Math.min(minD[0][i], Math.min(minD[1][i], minD[2][i]));
            
            if (val > max) {
                max = val;
                result = i;
            }
        }

        System.out.println(result);

        br.close();
    }
}