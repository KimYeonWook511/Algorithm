import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        for (int i = 1; i < N; i++) {
            long num = (long)(Math.pow(i, 3) - 1) % deque.size();

            while (true) {
                if (num <= 0) break;

                deque.offer(deque.poll());

                num--;
            }

            deque.poll();
        }

        System.out.println(deque.poll());

        br.close();
    }
}