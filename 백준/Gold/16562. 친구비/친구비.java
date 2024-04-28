import java.io.*;
import java.util.*;

public class Main {
    static int parent[], A[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        A = new int[N + 1];
        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w);
        }

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) sum += A[i];
        }

        System.out.println(sum > k ? "Oh no" : sum);

        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (A[x] < A[y]) parent[y] = x;
        else parent[x] = y;
    }
}