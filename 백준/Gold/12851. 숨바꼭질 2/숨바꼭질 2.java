import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        int chk[] = new int[200_001];

        for (int i = 0; i <= 200_000; i++) {
            chk[i] = Integer.MAX_VALUE;
        }

        deque.offer(new int[]{N, 0});
        chk[N] = 0;

        int cur[];
        int cnt = 0;
        int temp = -1;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (temp != -1) {
                if (cur[1] > temp) break;

                if (cur[0] == K) cnt++;

                continue;
            }

            if (cur[0] == K) {
                cnt++;
                temp = cur[1];
                sb.append(cur[1]).append("\n");
                continue;
            }

            if (cnt > 0) break;

            if (cur[0] - 1 >= 0 && chk[cur[0] - 1] > cur[1]) {
                deque.offer(new int[]{cur[0] - 1, cur[1] + 1});
                chk[cur[0] - 1] = cur[1] + 1;
            }

            if (cur[0] + 1 <= K && chk[cur[0] + 1] > cur[1]) {
                deque.offer(new int[]{cur[0] + 1, cur[1] + 1});
                chk[cur[0] + 1] = cur[1] + 1;
            }

            if (cur[0] << 1 <= 200_000 && chk[cur[0] << 1] > cur[1]) {
                deque.offer(new int[]{cur[0] << 1, cur[1] + 1});
                chk[cur[0] << 1] = cur[1] + 1;
            }
        }

        sb.append(cnt);
        System.out.println(sb);

        br.close();
    }
}