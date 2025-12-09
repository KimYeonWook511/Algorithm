import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int h, cnt;

        Node (int h, int cnt) {
            this.h = h;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>(); // stack처럼 사용

        long answer = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            Node cur = new Node(h, 1);

            while (!deque.isEmpty() && deque.peekLast().h < cur.h) {
                answer += deque.pollLast().cnt;
            }

            if (!deque.isEmpty() && deque.peekLast().h == cur.h) {
                answer += deque.peekLast().cnt;
                cur.cnt += deque.pollLast().cnt;
            }

            if (!deque.isEmpty()) {
                answer++;
            }

            deque.offerLast(cur);
        }

        System.out.println(answer);

        br.close();
    }
}