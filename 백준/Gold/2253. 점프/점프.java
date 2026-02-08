import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, s, cnt;

        Node (int i, int s, int cnt) {
            this.i = i;
            this.s = s;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[] = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }

        int maxSpeed = (int)Math.sqrt(2 * N) + 2;
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N + 1][maxSpeed + 1];

        if (!arr[2]) {
            deque.add(new Node(2, 1, 1));
            visited[2][1] = true;
        }

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.i == N) {
                answer = cur.cnt;
                break;
            }

            for (int ns = cur.s - 1; ns <= cur.s + 1; ns++) {
                if (ns < 1) continue;

                if (cur.i + ns > N) continue;
                if (arr[cur.i + ns]) continue;
                if (ns > maxSpeed) continue;

                if (!visited[cur.i + ns][ns]) {
                    deque.add(new Node(cur.i + ns, ns, cur.cnt + 1));
                    visited[cur.i + ns][ns] = true;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}