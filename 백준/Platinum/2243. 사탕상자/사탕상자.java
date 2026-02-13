import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_NUM = 1_000_000;
    static int tree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new int[getTreeSize()];

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 1) {
                // int start = 1;
                // int end = MAX_NUM;
                // while (start <= end) {
                //     int mid = (start + end) / 2;
                //     int rank = query(1, 1, MAX_NUM, start, mid); // start~mid까지 사탕이 몇개 있는가==rank
                //
                //     if (rank < B) {
                //         start = mid + 1;
                //         B -= rank;
                //     } else {
                //         end = mid - 1;
                //     }
                // }
                // update(1, 1, MAX_NUM, start, -1);

                sb.append(find(1, 1, MAX_NUM, B)).append("\n");
            } else {
                int C = Integer.parseInt(st.nextToken());
                update(1, 1, MAX_NUM, B, C);
            }
        }

        System.out.println(sb);

        br.close();
    }

    static int getTreeSize() {
        int size = 1;
        while (size < MAX_NUM) {
            size <<= 1;
        }
        size <<= 1;
        return size;
    }

    static int query(int node, int left, int right, int start, int end) {
        if (right < start || end < left) return 0;
        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;
        int leftVal = query(node * 2, left, mid, start, end);
        int rightVal = query(node * 2 + 1, mid + 1, right, start, end);

        return leftVal + rightVal;
    }

    static int find(int node, int left, int right, int rank) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }

        int mid = (left + right) / 2;
        int ret = 0;
        if (tree[node * 2] >= rank) {
            ret = find(node * 2, left, mid, rank);
        } else {
            ret = find(node * 2 + 1, mid + 1, right, rank - tree[node * 2]);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return ret;
    }

    static void update(int node, int left, int right, int targetIndex, int val) {
        if (left == right) {
            tree[node] += val;
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