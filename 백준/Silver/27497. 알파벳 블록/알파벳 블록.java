import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Boolean> chk = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                deque.offerLast(st.nextToken().charAt(0));
                chk.offer(true);

            } else if (cmd == 2) {
                deque.offerFirst(st.nextToken().charAt(0));
                chk.offer(false);

            } else if (!deque.isEmpty()) {
                if (chk.pollLast()) deque.pollLast();
                else deque.pollFirst();
            }
        }

        if (deque.isEmpty()) {
            sb.append("0");
        }

        while (!deque.isEmpty()) {
            sb.append(deque.poll());
        }

        System.out.println(sb);

        br.close();
    }
}