import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast()[0] >= num) {
                deque.pollLast();
            }

            deque.offer(new int[] {num, i});

            if (deque.peek()[1] <= i - L) deque.poll();

            sb.append(deque.peek()[0]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}