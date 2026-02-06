import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, W;
    static Node arr[];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        arr = new Node[W + 1];
        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Node(r, c);
        }

        dp = new int[W + 1][W + 1];
        func(0, 0, 1);

        StringBuilder sb = new StringBuilder();
        sb.append(dp[0][0]).append("\n");
        tracking(sb);

        System.out.println(sb);

        br.close();
    }

    static int func(int a, int b, int target) {
        if (a == W || b == W) return 0;
        if (dp[a][b] != 0) return dp[a][b];

        int ar = a == 0 ? 1 : arr[a].r;
        int ac = a == 0 ? 1 : arr[a].c;
        int br = b == 0 ? N : arr[b].r;
        int bc = b == 0 ? N : arr[b].c;

        int val1 = (Math.abs(ar - arr[target].r) + Math.abs(ac - arr[target].c)) + func(target, b, target + 1);
        int val2 = (Math.abs(br - arr[target].r) + Math.abs(bc - arr[target].c)) + func(a, target, target + 1);

        return dp[a][b] = Math.min(val1, val2);
    }

    static void tracking(StringBuilder sb) {
        int a = 0;
        int b = 0;
        int ar = 1;
        int ac = 1;
        int target = 1;
        while (target <= W) {
            if (dp[a][b] == Math.abs(ar - arr[target].r) + Math.abs(ac - arr[target].c) + dp[target][b]) {
                sb.append(1).append("\n");
                a = target;
                ar = arr[target].r;
                ac = arr[target].c;
            } else {
                sb.append(2).append("\n");
                b = target;
            }
            
            target++;
        }
    }
}