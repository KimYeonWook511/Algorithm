import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    static int queryParent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        queryParent = new int[N + 1];

        parent[1] = 1;
        queryParent[1] = 1;
        for (int i = 2; i <= N; i++) {
            int a = Integer.parseInt(br.readLine());

            parent[i] = a;
            queryParent[i] = i;
        }

        int query[][] = new int[N + Q][3]; // 12_000_000 * 3 * 4 byte -> 약 137MB

        for (int i = 1; i < N + Q; i++) {
            st = new StringTokenizer(br.readLine());
            query[i][0] = Integer.parseInt(st.nextToken());
            query[i][1] = Integer.parseInt(st.nextToken());
            
            if (query[i][0] == 1) query[i][2] = Integer.parseInt(st.nextToken());
        }

        String result[] = new String[Q];
        int resultIdx = Q - 1;
        for (int i = N + Q - 1; i > 0; i--) {
            if (query[i][0] == 0) {
                int b = query[i][1];

                queryParent[b] = parent[b];

            } else {
                int c = query[i][1];
                int d = query[i][2];

                result[resultIdx--] = find(c) == find(d) ? "YES\n" : "NO\n";
            }
        }

        for (int i = 0; i < Q; i++) {
            sb.append(result[i]);
        }

        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        if (x == queryParent[x]) return x;

        return queryParent[x] = find(queryParent[x]);
    }
}