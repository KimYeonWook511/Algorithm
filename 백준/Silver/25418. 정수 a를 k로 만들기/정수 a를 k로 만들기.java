import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dist[] = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            dist[i] = -1;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(A);
        dist[A] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == K) break;

            int next1 = cur + 1;
            if (next1 <= K && dist[next1] == -1) {
                deque.offer(next1);
                dist[next1] = dist[cur] + 1;
            }

            int next2 = cur * 2;
            if (next2 <= K && dist[next2] == -1) {
                deque.offer(next2);
                dist[next2] = dist[cur] + 1;
            }
        }

        System.out.println(dist[K]);

        br.close();
    }
}
