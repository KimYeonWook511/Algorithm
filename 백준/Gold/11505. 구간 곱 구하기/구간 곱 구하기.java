import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    static long arr[];
    static long tree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[getTreeSize(N)];
        buildTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < M + K; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, N, b, c);
            } else {
                long answer = query(1, 1, N, b, c);
                sb.append(answer).append("\n");
            }
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

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }

    static long query(int node, int left, int right, int start, int end) {
        // 범위 밖
        if (right < start || end < left) return 1;
        // 범위 안
        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;
        long leftResult = query(node * 2, left, mid, start, end);
        long rightResult = query(node * 2 + 1, mid + 1, right, start, end);

        return (leftResult * rightResult) % MOD;
    }

    static void update(int node, int left, int right, int targetIndex, long val) {
        if (left == right) {
            // arr[targetIndex] = val;
            tree[node] = val;
            return;
        }

        int mid = (left + right) / 2;
        if (targetIndex <= mid) {
            update(node * 2, left, mid, targetIndex, val);
        } else {
            update(node * 2 + 1, mid + 1, right, targetIndex, val);
        }

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }
}