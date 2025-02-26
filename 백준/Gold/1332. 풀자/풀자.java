import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int P[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        boolean chk[][][] = new boolean[N][1001][1001];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.offer(new int[]{0, P[0], P[0], 1});
        chk[0][P[0]][P[0]] = true;

        int result = N;
        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur[0] + 2 < N) {
                int tempMax = Math.max(cur[1], P[cur[0] + 2]);
                int tempMin = Math.min(cur[2], P[cur[0] + 2]);

                if (tempMax - tempMin >= V) {
                    result = cur[3] + 1;
                    break;
                }

                if (!chk[cur[0] + 2][tempMax][tempMin]) {
                    chk[cur[0] + 2][tempMax][tempMin] = true;
                    deque.offer(new int[]{cur[0] + 2, tempMax, tempMin, cur[3] + 1});
                }
            }

            if (cur[0] + 1 < N) {
                int tempMax = Math.max(cur[1], P[cur[0] + 1]);
                int tempMin = Math.min(cur[2], P[cur[0] + 1]);

                if (tempMax - tempMin >= V) {
                    result = cur[3] + 1;
                    break;
                }

                if (!chk[cur[0] + 1][tempMax][tempMin]) {
                    chk[cur[0] + 1][tempMax][tempMin] = true;
                    deque.offer(new int[]{cur[0] + 1, tempMax, tempMin, cur[3] + 1});
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}