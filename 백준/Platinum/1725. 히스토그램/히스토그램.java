import java.io.*;
import java.util.*;

public class Main {
    static class Bar {
        long r, c; // 범위는 int이지만 곱하기 연산으로 매번 캐스팅을 피하기 위해 long 자료형 사용

        Bar (long r, long c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Bar> deque = new ArrayDeque<>();
        deque.offer(new Bar(0, 0)); // isEmpty 처리를 위한 초기화 입력

        int N = Integer.parseInt(br.readLine());
        long result = 0;
        for (long c = 1; c <= N; c++) {
            long r = Long.parseLong(br.readLine());

            Bar top = deque.peekLast();
            if (top.r < r) {
                deque.offer(new Bar(r, c));

            } else if (top.r > r) {
                // 막대 빼기
                result = Math.max(result, top.r * (c - top.c));
                Bar pre = deque.pollLast();

                while (true) {
                    top = deque.peekLast();

                    if (top.r == r) break;
                    if (top.r < r) {
                        deque.offer(new Bar(r, pre.c));
                        break;
                    }

                    result = Math.max(result, top.r * (c - top.c));
                    pre = deque.pollLast();
                }
            }
        }

        while (true) {
            Bar top = deque.pollLast();

            if (top.r == 0) break;

            result = Math.max(result, top.r * (N + 1 - top.c));
        }

        System.out.println(result);

        br.close();
    }
}