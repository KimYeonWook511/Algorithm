import java.io.*;
import java.util.*;

public class Main {
    static int n, arr[][];
    static double dp[][][];
    static int allVisitedBit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2]; // 전체 순열 중 적어도 한 개의 순열은 선분들이 안 곂치지 않나?

        allVisitedBit = (1 << n) - 1;
        dp = new double[n][n][allVisitedBit + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        double result = Double.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            result = Math.min(result, func(start, start, 1 << start));
        }

        System.out.println(result);

        br.close();
    }

    static double func(int start, int cur, int visitedBit) {
        // end -> start
        if (visitedBit == allVisitedBit) return Math.sqrt(Math.pow(arr[cur][0] - arr[start][0], 2) + Math.pow(arr[cur][1] - arr[start][1], 2));

        // 남은 순열의 최적해를 반환
        if (dp[start][cur][visitedBit] != 0) return dp[start][cur][visitedBit];

        dp[start][cur][visitedBit] = Double.MAX_VALUE;
        for (int next = 0; next < n; next++) {
            if ((visitedBit & (1 << next)) != 0) continue;

            double d = Math.sqrt(Math.pow(arr[cur][0] - arr[next][0], 2) + Math.pow(arr[cur][1] - arr[next][1], 2));

            dp[start][cur][visitedBit] = Math.min(dp[start][cur][visitedBit], d + func(start, next, visitedBit | (1 << next)));
        }

        return dp[start][cur][visitedBit];
    }
}