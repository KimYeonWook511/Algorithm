import java.io.*;
import java.util.*;

public class Main {
    static int tree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];
        int sorted[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        sorted[0] = Integer.MIN_VALUE;
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }
        int maxRank = rank - 1;
        tree = new int[getTreeSize(maxRank)]; // maxRank <= N

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            rank = map.get(arr[i]);
            answer += query(1, 1, maxRank, rank + 1, maxRank);
            update(1, 1, maxRank, rank);
        }

        System.out.println(answer);

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

    static long query(int node, int left, int right, int start, int end) {
        // 범위 밖
        if (right < start || end < left) return 0;
        // 범위 해당
        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;
        long leftResult = query(node * 2, left, mid, start, end);
        long rightResult = query(node * 2 + 1, mid + 1, right, start, end);

        return leftResult + rightResult;
    }

    static void update(int node, int left, int right, int targetIndex) {
        if (left == right) {
            tree[node]++;
            return;
        }

        int mid = (left + right) / 2;
        if (targetIndex <= mid) {
            update(node * 2, left, mid, targetIndex);
        } else {
            update(node * 2 + 1, mid + 1, right, targetIndex);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}