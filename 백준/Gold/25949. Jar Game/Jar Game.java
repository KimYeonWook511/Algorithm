import java.io.*;
import java.util.*;

public class Main {
    static int dp[][][][] = new int[30][101][101][101];
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int jar[] = new int[3];

        for (int i = 0; i < 3; i++) {
            jar[i] = Integer.parseInt(st.nextToken());
        }

        int f = func(1, jar[0], jar[1], jar[2]);
        int s = jar[0] + jar[1] + jar[2] - f;

        if (f == s) System.out.println("D");
        else if (f > s) System.out.println("F");
        else System.out.println("S");

        br.close();
    }

    public static int func (int i, int a, int b, int c) {
        if (dp[i][a][b][c] != 0) return dp[i][a][b][c];

        if (a == 0 && b == 0 && c == 0) return 0;

        int minA = Math.min(a, i);
        int minB = Math.min(b, i);
        int minC = Math.min(c, i);

        if (i % 2 == 1) {
            // F
            if (minA > 0) dp[i][a][b][c] = Math.max(dp[i][a][b][c], func(i + 1, a - minA, b, c) + minA);
            if (minB > 0) dp[i][a][b][c] = Math.max(dp[i][a][b][c], func(i + 1, a, b - minB, c) + minB);
            if (minC > 0) dp[i][a][b][c] = Math.max(dp[i][a][b][c], func(i + 1, a, b, c - minC) + minC);

        } else {
            // S
            dp[i][a][b][c] = MAX;
            if (minA > 0) dp[i][a][b][c] = Math.min(dp[i][a][b][c], func(i + 1, a - minA, b, c));
            if (minB > 0) dp[i][a][b][c] = Math.min(dp[i][a][b][c], func(i + 1, a, b - minB, c));
            if (minC > 0) dp[i][a][b][c] = Math.min(dp[i][a][b][c], func(i + 1, a, b, c - minC));
        }

        return dp[i][a][b][c];
    }
}