import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m, n, x, y, z;
        Node arr[];

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            if (m == 0) break;

            n = Integer.parseInt(st.nextToken());

            parent = new int[m + 1];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            arr = new Node[n];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());

                arr[i] = new Node(x, y, z);
                sum += z;
            }

            Arrays.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.z, o2.z);
                }
            });

            int cnt = m - 1;
            for (int i = 0; i < n; i++) {
                if (union(arr[i].x, arr[i].y)) continue;

                sum -= arr[i].z;

                if (--cnt == 0) break;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;

        if (x < y) parent[y] = x;
        else parent[x] = y;

        return false;
    }
}