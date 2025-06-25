import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int nodeCnt = (1 << (k + 1)) - 1;
        int tree[] = new int[nodeCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < nodeCnt; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0; // 최대는 (2^21 - 1) * 1000
        for (int i = (nodeCnt >> 1) - 1; i >= 0; i--) {
            int left = tree[(i << 1) + 1];
            int right = tree[(i << 1) + 2];
            int max = Math.max(left, right);

            sum += max;
            tree[i] += max;
        }
        sum += tree[0]; // 한 쪽 가지 더 더하기

        System.out.println(sum);

        br.close();
    }
}