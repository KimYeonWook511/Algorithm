import java.io.*;
import java.util.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        parent = new int[V + 1];
        // int edge[][] = new int[E][3];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{A, B, C});
        }

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int cnt = V - 1;
        int sum = 0;

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (!union(cur[0], cur[1])) continue;

            sum += cur[2];
            if (--cnt == 0) break;
        }

        System.out.println(sum);

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