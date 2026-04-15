import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long val[] = new long[N + 1];
        int to[] = new int[N + 1];
        int indegree[] = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            long a = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            val[i] = t == 'S' ? a : -a;
            to[i] = p;
            indegree[p]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 2; i <= N; i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            int next = to[cur];
            val[next] += Math.max(0, val[cur]);
            if (--indegree[next] == 0) {
                deque.offer(next);
            }
        }

        System.out.println(val[1]);

        br.close();
    }
}