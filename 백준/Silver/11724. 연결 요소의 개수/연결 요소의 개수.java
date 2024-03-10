import java.io.*;
import java.util.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        boolean notParent[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            notParent[union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))] = true;
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!notParent[i]) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return 0;

        if (x < y) {
            parent[y] = x;
            return y;
        }

        parent[x] = y;
        return x;
    }
}