import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int Rs[] = new int[N + 1];
        int Wk[] = new int[M + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
            pq.offer(i);
        }

        for (int i = 1; i <= M; i++) {
            Wk[i] = Integer.parseInt(br.readLine());
        }

        int arr[] = new int[M + 1];
        int result = 0;

        for (int run = (M << 1); run > 0; run--) {
            int i = Integer.parseInt(br.readLine());

            if (i > 0) {
                if (pq.isEmpty()) {
                    deque.offer(i);
                    continue;
                }

                arr[i] = pq.poll();
                result += Rs[arr[i]] * Wk[i];

            } else {
                if (deque.isEmpty()) {
                    pq.offer(arr[i * -1]);
                    continue;
                }

                int idx = deque.poll();
                arr[idx] = arr[i * -1];
                result += Rs[arr[idx]] * Wk[idx];
            }
        }

        System.out.println(result);

        br.close();
    }
}