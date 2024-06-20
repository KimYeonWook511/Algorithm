import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        boolean rev = false;
        int size = N;
        int cnt = 0;
        int rep = 0;

        while (size != 0) {
            rep = size >= K ? K : ((K + size - 1) % size) + 1;

            if (rev) {
                for (int i = 1; i < rep; i++) {
                    deque.offerFirst(deque.pollLast());
                }

                sb.append(deque.pollLast()).append("\n");

            } else {
                for (int i = 1; i < rep; i++) {
                    deque.offerLast(deque.pollFirst());
                }

                sb.append(deque.pollFirst()).append("\n");
            }

            size--;
            if (++cnt != M) continue;

            rev = !rev;
            cnt = 0;
        }

        System.out.println(sb);

        br.close();
    }
}
