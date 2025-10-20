import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int n, k;
        int t;

        Node (int n, int k, int t) {
            this.n = n;
            this.t = t;
            this.k = k;
        }
    }
    static final int MAX = 500_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[MAX + 1][2]; // 0: 짝수, 1: 홀수
        deque.offer(new Node(N, K, 0));
        visited[N][0] = true;

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (visited[cur.k][cur.t % 2]) {
                answer = cur.t;
                break;
            }

            int nt = cur.t + 1;
            int nk = cur.k + nt;
            if (nk > MAX) {
                continue;
            }

            // -1
            int nextEvenOdd = nt % 2;
            if (cur.n - 1 >= 0) {
                if (!visited[cur.n - 1][nextEvenOdd]) {
                    deque.offer(new Node(cur.n - 1, nk, nt));
                    visited[cur.n - 1][nextEvenOdd] = true;
                }
            }

            // +1
            if (cur.n + 1 <= MAX) {
                if (!visited[cur.n + 1][nextEvenOdd]) {
                    deque.offer(new Node(cur.n + 1, nk, nt));
                    visited[cur.n + 1][nextEvenOdd] = true;
                }
            }

            // *2
            if (cur.n * 2 <= MAX) {
                if (!visited[cur.n * 2][nextEvenOdd]) {
                    deque.offer(new Node(cur.n * 2, nk, nt));
                    visited[cur.n * 2][nextEvenOdd] = true;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}