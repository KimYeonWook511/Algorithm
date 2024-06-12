import java.io.*;
import java.util.*;

public class Main {
    static int dp[][][], result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[arr[0] + 1][arr[1] + 1][arr[2] + 1];

        func(arr[0], arr[1], arr[2], 0);

        System.out.println(result);

        br.close();
    }

    static void func(int hp1, int hp2, int hp3, int cnt) {
        if (cnt >= result) return;

        if (hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
            result = Math.min(result, cnt);
            return;
        }

        hp1 = Math.max(hp1, 0);
        hp2 = Math.max(hp2, 0);
        hp3 = Math.max(hp3, 0);
        if (dp[hp1][hp2][hp3] != 0 && dp[hp1][hp2][hp3] <= cnt) return;

        dp[hp1][hp2][hp3] = cnt;

        func(hp1 - 9, hp2 - 1, hp3 - 3, cnt + 1);
        func(hp1 - 9, hp2 - 3, hp3 - 1, cnt + 1);

        func(hp1 - 3, hp2 - 1, hp3 - 9, cnt + 1);
        func(hp1 - 3, hp2 - 9, hp3 - 1, cnt + 1);

        func(hp1 - 1, hp2 - 3, hp3 - 9, cnt + 1);
        func(hp1 - 1, hp2 - 9, hp3 - 3, cnt + 1);
    }
}