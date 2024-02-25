import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int graph[][] = new int[N][N];
        boolean chk[] = new boolean[N];
        int min[] = new int[N];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            min[i] = Integer.parseInt(br.readLine());

            pq.offer(new int[]{i, min[i]});
        }

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int cnt = N;

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (chk[cur[0]]) continue;
            chk[cur[0]] = true;
            sum += cur[1] < min[cur[0]] ? cur[1] : min[cur[0]];

            if (--cnt == 0) break;

            for (int next = 0; next < N; next++) {
                if (chk[next]) continue;
                if (graph[cur[0]][next] >= min[next]) continue;

                min[next] = graph[cur[0]][next];
                pq.offer(new int[]{next, min[next]});
            }
        }

        System.out.println(sum);

        br.close();
    }
}