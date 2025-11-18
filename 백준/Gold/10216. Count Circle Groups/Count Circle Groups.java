import java.io.*;
import java.util.*;

public class Main {
    static class Area {
        int x, y, R;

        Area (int x, int y, int R) {
            this.x = x;
            this.y = y;
            this.R = R;
        }
    }
    static int parent[];
    static int rank[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Area areas[] = new Area[N];
            parent = new int[N];
            rank = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                areas[i] = new Area(x, y, R);
                parent[i] = i;
                rank[i] = 0;
            }

            int answer = N;
            for (int i = 0; i < N; i++) {
                for (int k = i + 1; k < N; k++) {
                    int x = areas[i].x - areas[k].x;
                    int y = areas[i].y - areas[k].y;
                    int R = areas[i].R + areas[k].R;

                    if (x * x + y * y > R * R) continue;

                    if (union(i, k)) {
                        answer--;
                    }
                }
            }

            sb.append(answer).append("\n");
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

        if (x == y) return false;

        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }

        return true;
    }
}