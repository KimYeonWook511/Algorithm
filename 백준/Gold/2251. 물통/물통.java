import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean result[] = new boolean[C + 1];
        boolean chk[][][] = new boolean[201][201][201];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.offer(new int[]{0, 0, C});
        chk[0][0][C] = true;

        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur[0] == 0) result[cur[2]] = true;

            int from, to;
            // A
            from = Math.max(cur[0] + cur[1] - B, 0);
            to = Math.min(cur[0] + cur[1], B);
            if (!chk[from][to][cur[2]]) {
                deque.offer(new int[]{from, to, cur[2]});
                chk[from][to][cur[2]] = true;
            }

            from = Math.max(cur[0] + cur[2] - C, 0);
            to = Math.min(cur[0] + cur[2], C);
            if (!chk[from][cur[1]][to]) {
                deque.offer(new int[]{from, cur[1], to});
                chk[from][cur[1]][to] = true;
            }

            // B
            from = Math.max(cur[1] + cur[0] - A, 0);
            to = Math.min(cur[1] + cur[0], A);
            if (!chk[to][from][cur[2]]) {
                deque.offer(new int[]{to, from, cur[2]});
                chk[to][from][cur[2]] = true;
            }

            from = Math.max(cur[1] + cur[2] - C, 0);
            to = Math.min(cur[1] + cur[2], C);
            if (!chk[cur[0]][from][to]) {
                deque.offer(new int[]{cur[0], from, to});
                chk[cur[0]][from][to] = true;
            }

            // C
            from = Math.max(cur[2] + cur[0] - A, 0);
            to = Math.min(cur[2] + cur[0], A);
            if (!chk[to][cur[1]][from]) {
                deque.offer(new int[]{to, cur[1], from});
                chk[to][cur[1]][from] = true;
            }

            from = Math.max(cur[2] + cur[1] - B, 0);
            to = Math.min(cur[2] + cur[1], B);
            if (!chk[cur[0]][to][from]) {
                deque.offer(new int[]{cur[0], to, from});
                chk[cur[0]][to][from] = true;
            }
        }

        for (int i = 0; i <= C; i++) {
            if (!result[i]) continue;

            sb.append(i).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}