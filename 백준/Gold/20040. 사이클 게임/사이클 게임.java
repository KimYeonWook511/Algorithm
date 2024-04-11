import java.io.*;
import java.util.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;

        for (int run = 1; run <= m; run++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union(a, b)) {
                result = run;

                for (int run2 = run; run2 < m; run2++) {
                    br.readLine();
                }

                break;
            }
        }

        System.out.println(result);

        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;

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