import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int step[];
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.countTokens();
        step = new int[n];
        dp = new int[n][5][5];

        for (int i = 1; i < n; i++) {
            step[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) System.out.println(0);
        else System.out.println(func(2, step[1], 0) + 2);

        br.close();
    }

    static int func(int i, int left, int right) {
        if (i == n) return 0;

        if (dp[i][left][right] != 0) return dp[i][left][right];

        int lf = force(left, step[i]) + func(i + 1, step[i], right);
        int rf = force(right, step[i]) + func(i + 1, left, step[i]);

        dp[i][left][right] = Math.min(lf, rf);

        return dp[i][left][right];
    }

    static int force(int before, int after) {
        if (before == 0) return 2;

        int val = Math.abs(before - after);

        if (val == 0) return 1;
        else if (val % 2 == 0) return 4;
        else return 3;
    }
}