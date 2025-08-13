import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Deque<Integer> aDeque = new ArrayDeque<>();
        Deque<Integer> bDeque = new ArrayDeque<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A') aDeque.offer(i);
            else if (input.charAt(i) == 'B') bDeque.offer(i);
            else if (!bDeque.isEmpty() && bDeque.peek() < i) {
                bDeque.poll();
                result++;
            }
        }

        while (!aDeque.isEmpty() && !bDeque.isEmpty()) {
            if (aDeque.peek() >= bDeque.poll()) continue;

            aDeque.poll();
            result++;
        }

        System.out.println(result);

        br.close();
    }
}