import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        boolean chk[] = new boolean[F + 1];
        deque.offer(new int[]{S, 0});
        chk[S] = true;

        int result = -1;
        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur[0] == G) {
                result = cur[1];
                break;
            }

            if (cur[0] + U <= F && !chk[cur[0] + U]) {
                deque.offer(new int[]{cur[0] + U, cur[1] + 1});
                chk[cur[0] + U] = true;
            }

            if (cur[0] - D > 0 && !chk[cur[0] - D]) {
                deque.offer(new int[]{cur[0] - D, cur[1] + 1});
                chk[cur[0] - D] = true;
            }
        }

        System.out.println(result == -1 ? "use the stairs" : result);

        br.close();
    }
}