import java.io.*;
import java.util.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 100,000
        int M = Integer.parseInt(st.nextToken()); // 500,000

        int edge[][] = new int[M][3];
        long sum = 0;

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());
            sum += edge[i][2];

            pq.offer(edge[i]);
        }

        int cnt = N - 1;

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (!union(cur[0], cur[1])) continue;

            sum -= cur[2];

            if (--cnt == 0) break;
        }

        System.out.println(cnt == 0 ? sum : "-1");

        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x < y) parent[y] = x;
        else parent[x] = y;

        return true;
    }
}