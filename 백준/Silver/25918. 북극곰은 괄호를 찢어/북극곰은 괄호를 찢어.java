import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int result = -1;

        if (N % 2 == 0) {
            Deque<Character> deque = new ArrayDeque<>();
            char ch = 0;

            for (int i = 0; i < N; i++) {
                ch = input.charAt(i);

                if (deque.isEmpty() || deque.peekLast() == ch) deque.offer(ch);
                else deque.pollLast();

                result = Math.max(result, deque.size());
            }   

            if (!deque.isEmpty()) result = -1;
        }

        System.out.println(result);

        br.close();
    }
}