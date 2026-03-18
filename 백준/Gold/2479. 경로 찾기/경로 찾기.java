import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int codes[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int k = 0; k < K; k++) {
                codes[i] <<= 1;
                if (str.charAt(k) == '1') {
                    codes[i] |= 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        int visited[] = new int[N + 1];
        deque.offer(A);
        visited[A] = A;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == B) break;

            for (int i = 1; i <= N; i++) {
                if (visited[i] != 0) continue;

                int xor = codes[cur] ^ codes[i];
                if ((xor & (xor - 1)) == 0) {
                    deque.offer(i);
                    visited[i] = cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (visited[B] == 0) {
            sb.append("-1");
        } else {
            List<Integer> tracking = new ArrayList<>();
            tracking.add(B);
            int cur = B;
            while (cur != visited[cur]) {
                tracking.add(visited[cur]);
                cur = visited[cur];
            }

            for (int i = tracking.size() - 1; i >= 0; i--) {
                sb.append(tracking.get(i)).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}