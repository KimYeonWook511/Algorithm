import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, cnt;

        Node (int i, int cnt) {
            this.i = i;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[N + 1];
        deque.offer(new Node(a, 0));

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.i == b) {
                answer = cur.cnt;
                break;
            }

            for (int next = cur.i + arr[cur.i]; next <= N; next += arr[cur.i]) {
                if (visited[next]) continue;

                deque.offer(new Node(next, cur.cnt + 1));
                visited[next] = true;
            }

            for (int next = cur.i - arr[cur.i]; next >= 1; next -= arr[cur.i]) {
                if (visited[next]) continue;

                deque.offer(new Node(next, cur.cnt + 1));
                visited[next] = true;
            }
        }

        System.out.println(answer);

        br.close();
    }
}