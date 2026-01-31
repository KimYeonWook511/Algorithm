import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static int minTree[];
    static int maxTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        minTree = new int[getTreeSize(N)];
        maxTree = new int[minTree.length];
        buildTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result[] = query(1, 1, N, a, b);

            sb.append(result[0]).append(" ").append(result[1]).append("\n");
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
            minTree[node] = arr[left];
            maxTree[node] = arr[left];
            return;
        }

        int mid = (left + right) / 2;
        buildTree(node * 2, left, mid);
        buildTree(node * 2 + 1, mid + 1, right);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static int[] query(int node, int left, int right, int start, int end) {
        // 범위 밖
        if (end < left || right < start) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        // 완전 포함
        if (start <= left && right <= end) return new int[]{minTree[node], maxTree[node]};

        int mid = (left + right) / 2;
        int leftResult[] = query(node * 2, left, mid, start, end);
        int rightResult[] = query(node * 2 + 1, mid + 1, right, start, end);

        int min = Math.min(leftResult[0], rightResult[0]);
        int max = Math.max(leftResult[1], rightResult[1]);
        return new int[]{min, max};
    }
}