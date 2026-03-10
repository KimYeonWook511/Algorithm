import java.io.*;
import java.util.*;

public class Main {

    static final long MAX = 100_001;

    static class Node {
        long val;
        int count;

        Node (long val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        long target = c * MAX + d;

        Deque<Node> deque = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        deque.offer(new Node(0L, 0));
        visited.add(0L);

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.val == target) {
                answer = cur.count;
                break;
            }

            long A = cur.val / MAX;
            long B = cur.val % MAX;
            long nextVal = 0;
            int nextCount = cur.count + 1;

            // A 기준
            nextVal = a * MAX + B;
            check(nextVal, nextCount, deque, visited);
            nextVal = B;
            check(nextVal, nextCount, deque, visited);
            if (A <= b - B) {
                nextVal = B + A;
            } else {
                nextVal = (A - (b - B)) * MAX + b;
            }
            check(nextVal, nextCount, deque, visited);

            // B 기준
            nextVal = A * MAX + b;
            check(nextVal, nextCount, deque, visited);
            nextVal = A * MAX;
            check(nextVal, nextCount, deque, visited);
            if (B <= a - A) {
                nextVal = (A + B) * MAX;
            } else {
                nextVal = a * MAX + (B - (a - A));
            }
            check(nextVal, nextCount, deque, visited);
        }

        System.out.println(answer);

        br.close();
    }

    static void check(long val, int count, Deque<Node> deque, Set<Long> visited) {
        if (!visited.contains(val)) {
            deque.offer(new Node(val, count));
            visited.add(val);
        }
    }
}