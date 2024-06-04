import java.io.*;
import java.util.*;

public class Main {
    static class Val {
        long num;
        int cnt;

        Val (long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = -1;

        if (A <= B) {
            Deque<Val> deque = new ArrayDeque<>();
            deque.offer(new Val(A, 0));

            while (!deque.isEmpty()) {
                Val cur = deque.poll();

                if (cur.num == B) {
                    result = cur.cnt + 1;
                    break;
                }

                if (cur.num * 10 + 1 <= B) deque.offer(new Val(cur.num * 10 + 1, cur.cnt + 1));
                if ((cur.num << 1) <= B) deque.offer(new Val(cur.num << 1, cur.cnt + 1));
            }
        }

        System.out.println(result);

        br.close();
    }
}