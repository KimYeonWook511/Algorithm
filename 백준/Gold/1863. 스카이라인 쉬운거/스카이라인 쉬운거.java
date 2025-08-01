import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // x
            int y = Integer.parseInt(st.nextToken());

            while (deque.peekLast() > y) {
                result++;
                deque.pollLast();
            }

            if (deque.peekLast() != y) deque.offer(y);
        }

        while (!deque.isEmpty()) {
            if (deque.pollLast() > 0) result++;
        }

        System.out.println(result);

        br.close();
    }
}