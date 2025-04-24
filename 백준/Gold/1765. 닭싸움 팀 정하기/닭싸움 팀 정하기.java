import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    static int enemyParent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        enemyParent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            enemyParent[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (cmd == 'E') {
                // 원수
                if (enemyParent[p] != p) union(enemyParent[p], q);
                enemyParent[p] = q;

                if (enemyParent[q] != q) union(enemyParent[q], p);
                enemyParent[q] = p;

            } else {
                // 친구
                union(p, q);
            }
        }

        int cnt = 0;
        boolean teamChk[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int team = find(i);

            if (teamChk[team]) continue;

            teamChk[team] = true;
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}