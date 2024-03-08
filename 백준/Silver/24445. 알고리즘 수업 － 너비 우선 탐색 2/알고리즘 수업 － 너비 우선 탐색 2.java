import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> graph[] = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].offer(b);
            graph[b].offer(a);
        }

        boolean chk[] = new boolean[N + 1];
        int num[] = new int[N + 1];
        int numCnt = 1;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(R);
        chk[R] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            num[cur] = numCnt++;

            PriorityQueue<Integer> curPq = graph[cur];

            while (!curPq.isEmpty()) {
                int next = curPq.poll();

                if (chk[next]) continue;
                
                chk[next] = true;
                deque.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(num[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}