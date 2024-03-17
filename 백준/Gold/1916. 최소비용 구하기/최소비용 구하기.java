import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]> graph[] = new ArrayList[N + 1];
        int min[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            graph[Integer.parseInt(st.nextToken())].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        boolean chk[] = new boolean[N + 1];

        pq.offer(new int[] {start, 0});
        min[start] = 0;

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (chk[cur[0]]) continue;
            if (cur[0] == end) {
                System.out.println(cur[1]);
                break;
            }

            chk[cur[0]] = true;

            for (int next[] : graph[cur[0]]) {
                if (chk[next[0]]) continue;
                if (min[next[0]] < min[cur[0]] + next[1]) continue;

                min[next[0]] = min[cur[0]] + next[1];
                pq.offer(new int[] {next[0], min[next[0]]});
            }
        }
        
        br.close();
    }
}