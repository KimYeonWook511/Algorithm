import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int A, B;

        Pair (int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(n + 1, n + 1));

        for (int i = 0; i < n; i++) {
            int A = Integer.parseInt(stA.nextToken());
            int B = Integer.parseInt(stB.nextToken());

            if (stack.isEmpty()) {
                stack.push(new Pair(A, B));
                continue;
            }

            if (stack.peek().A < A && stack.peek().B < B) {
                continue;
            }

            while (!stack.isEmpty()) {
                // peek.A 와 peek.B가 둘 다 작은 경우는 존재할 수 없음 (나의 로직상 이 경우가 발생할 수 없음)
                if (stack.peek().A < A || stack.peek().B < B) {
                    break;
                }

                // (peek.A > A && peek.B > B) 인 경우
                stack.pop();
            }

            stack.push(new Pair(A, B));
        }

        System.out.println(stack.size());

        br.close();
    }
}