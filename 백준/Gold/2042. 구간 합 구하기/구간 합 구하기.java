import java.io.*;
import java.util.*;

public class Main {
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
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < M + K; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 1, N, b, c);
            } else {
                sb.append(query(1, 1, N, b, (int)c)).append("\n");
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

    static void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
            return;
        }

        int mid = (left + right) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int left, int right, int start, int end) {
        // 범위 밖
        if (end < left || right < start) return 0;

        // 완전히 포함
        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;
        long leftSum = query(node * 2, left, mid, start, end);
        long rightSum = query(node * 2 + 1, mid + 1, right, start, end);

        return leftSum + rightSum;
    }

    static void update(int node, int left, int right, int targetIndex, long val) {
        if (left == right) {
            arr[targetIndex] = val;
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