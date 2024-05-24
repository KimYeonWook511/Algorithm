import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        parents = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());

            union(a, b);
        }

        stz = new StringTokenizer(br.readLine(), " ");
        int[] route = new int[n];
        for (int i = 0; i < n; i++) {
            route[i] = Integer.parseInt(stz.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = route[i];
            int b = route[i + 1];

            int r1 = find(a);
            int r2 = find(b);

            if (r1 != r2) cnt++;
        }

        System.out.println(cnt);
  
        br.close();
    }

    private static void union(int a, int b) {
        int r1 = find(a);
        int r2 = find(b);

        if (r1 == r2) return;

        if (r1 > r2) {
            parents[r1] = r2;
        } else {
            parents[r2] = r1;
        }
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return n;
        }
        // 상위 노드가 아닌 최상위 노드를 저장해 시간 단축
        return parents[n] = find(parents[n]);
    }
}