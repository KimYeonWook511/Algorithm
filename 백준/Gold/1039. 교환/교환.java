import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.toString(N).length();

        Deque<int[]> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[K + 1][1_000_001];
        deque.offer(new int[]{0, N});
        visited[0][N] = true;

        int result = -1;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            if (cur[0] == K) {
                result = Math.max(result, cur[1]);
                continue;
            }

            for (int i = 0; i < M; i++) {
                int pow1 = (int)Math.pow(10, M - 1 - i);
                int num1 = (cur[1] / pow1) % 10;

                for (int j = i + 1; j < M; j++) {
                    int pow2 = (int)Math.pow(10, M - 1 - j);
                    int num2 = (cur[1] / pow2) % 10;

                    if (i == 0 && num2 == 0) continue;

                    int nextNum = cur[1] - (num1 * pow1) - (num2 * pow2) + (num2 * pow1) + (num1 * pow2);

                    if (visited[cur[0] + 1][nextNum]) continue;

                    deque.offer(new int[]{cur[0] + 1, nextNum});
                    visited[cur[0] + 1][nextNum] = true;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}