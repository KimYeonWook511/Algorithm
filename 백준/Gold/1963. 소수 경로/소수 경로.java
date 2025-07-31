import java.io.*;
import java.util.*;

public class Main {
    static class Password {
        int num, cnt;

        Password (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean prime[] = new boolean[10000]; // false: 소수, true: 소수아님
        for (int i = 2; i < 10000; i++) {
            if (prime[i]) continue;

            for (int k = i * i; k < 10000; k += i) {
                prime[k] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Deque<Password> deque = new ArrayDeque<>();
            boolean visited[] = new boolean[10000];
            deque.offer(new Password(A, 0));
            visited[A] = true;

            String result = "Impossible";
            while (!deque.isEmpty()) {
                Password cur = deque.poll();

                if (cur.num == B) {
                    result = Integer.toString(cur.cnt);
                    break;
                }

                // 천의 자리
                for (int i = 1; i <= 9; i++) {
                    int nextNum = (i * 1000) + (cur.num % 1000);

                    if (prime[nextNum] || visited[nextNum]) continue;

                    deque.offer(new Password(nextNum, cur.cnt + 1));
                    visited[nextNum] = true;
                }

                // 백, 십, 일
                for (int i = 0; i <= 9; i++) {
                    for (int k = 1; k <= 100; k *= 10) {
                        int nextNum = (cur.num / (k * 10)) * (k * 10) + (cur.num % k) + (i * k);

                        if (prime[nextNum] || visited[nextNum]) continue;

                        deque.offer(new Password(nextNum, cur.cnt + 1));
                        visited[nextNum] = true;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}