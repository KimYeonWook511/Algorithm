import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static long tree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new long[getTreeSize(N)];
        buildTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(1, 1, N, Math.min(x, y), Math.max(x, y))).append("\n");
            update(1, 1, N, a, b);
        }

        System.out.println(sb);

        br.close();
    }

    static int getTreeSize(int N) {
        int size = 1;
        while (size < N) {
            size <<= 1;
        }
        size <<= 1;
        return size;
    }

    static void buildTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
            return;
        }

        int mid = (left + right) / 2;
        buildTree(node * 2, left, mid);
        buildTree(node * 2 + 1, mid + 1, right);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int left, int right, int start, int end) {
        // 범위 밖
        if (right < start || end < left) return 0;
        // 범위 포함
        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;
        return query(node * 2, left, mid, start, end) + query(node * 2 + 1, mid + 1, right, start, end);
    }

    static void update(int node, int left, int right, int targetIndex, int val) {
        if (left == right) {
            tree[node] = val;
            return;
        }

        int mid = (left + right) / 2;
        if (targetIndex <= mid) {
            update(node * 2, left, mid, targetIndex, val);
        } else {
            update(node * 2 + 1, mid + 1, right, targetIndex, val);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}