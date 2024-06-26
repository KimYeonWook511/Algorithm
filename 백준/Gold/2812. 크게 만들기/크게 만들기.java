import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Character> deque = new ArrayDeque<>();
        String str = br.readLine();
        char num = 0;

        for (int i = 0; i < N; i++) {
            num = str.charAt(i);

            while (!deque.isEmpty()) {
                if (K == 0) break;
                if (num <= deque.peekLast()) break;

                deque.pollLast();
                K--;
            }

            deque.offer(num);
        }

        for (int i = deque.size() - K; i > 0; i--) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb);

        br.close();
    }
}