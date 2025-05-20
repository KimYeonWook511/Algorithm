import java.io.*;
import java.util.*;

public class Main {
    static class Computer {
        int i, s;

        Computer (int i, int s) {
            this.i = i;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<Computer> graph[] = new ArrayList[n + 1];
            int minS[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                minS[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Computer(a, s));
            }

            PriorityQueue<Computer> pq = new PriorityQueue<>(new Comparator<Computer>() {
                @Override
                public int compare(Computer o1, Computer o2) {
                    return Integer.compare(o1.s, o2.s);
                }
            });
            boolean visited[] = new boolean[n + 1];
            pq.offer(new Computer(c, 0));
            minS[c] = 0;

            int cnt = 0;
            int lastTime = 0;
            while (!pq.isEmpty()) {
                Computer cur = pq.poll();

                if (visited[cur.i]) continue;
                visited[cur.i] = true;
                cnt++;
                lastTime = cur.s;

                for (Computer next : graph[cur.i]) {
                    if (minS[next.i] <= cur.s + next.s) continue;

                    minS[next.i] = cur.s + next.s;
                    pq.offer(new Computer(next.i, cur.s + next.s));
                }
            }

            sb.append(cnt).append(" ").append(lastTime).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}