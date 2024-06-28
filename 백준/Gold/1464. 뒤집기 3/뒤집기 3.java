import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length();
        Deque<Character> deque = new ArrayDeque<>();
        deque.offer(str.charAt(0));

        char c = 0;
        for (int i = 1; i < len; i++) {
            c = str.charAt(i);

            if (deque.peekFirst() >= c) deque.offerFirst(c);
            else deque.offerLast(c);
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb);

        br.close();
    }
}