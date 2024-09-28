import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[101];
        boolean chk[] = new boolean[101];

        for (int i = N + M; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{1, 0});
        chk[1] = true;

        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur[0] == 100) {
                System.out.println(cur[1]);
                break;
            }

            int next;
            for (int i = 1; i <= 6; i++) {
                next = cur[0] + i;

                if (next > 100) continue;
                if (chk[next]) continue;

                chk[cur[0] + i] = true;

                if (arr[next] != 0) next = arr[next];

                deque.offer(new int[]{next, cur[1] + 1});
            }
        }

        br.close();
    }
}