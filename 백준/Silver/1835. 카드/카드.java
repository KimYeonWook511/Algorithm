import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result[] = new int[N];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.offer(i);
        }

        int num = 1;
        while (!deque.isEmpty()) {
            for (int i = 0; i < num; i++) {
                deque.offerLast(deque.pollFirst());
            }

            result[deque.pollFirst()] = num++;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}