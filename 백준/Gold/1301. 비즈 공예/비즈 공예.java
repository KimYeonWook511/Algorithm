import java.io.*;

public class Main {
    static int N;
    static int cnt[] = new int[5];
    static long dp[][][][][][][] = new long[6][6][11][11][11][11][11]; // 들어갈 자리 바로 앞 두 개(앞 2차원) + 남은 구슬 개수(뒤 5차원)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            cnt[i] = Integer.parseInt(br.readLine());

            for (int k = 0; k < N; k++) {
                dp[i][k][0][0][0][0][0] = 1;
            }
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (i == k) continue;

                cnt[i]--;
                cnt[k]--;
                long val = func(i, k);
                if (val != -1) result += val;
                cnt[i]++;
                cnt[k]++;
            }
        }

        System.out.println(result);

        br.close();
    }

    static long func(int first, int second) {
        if (dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]] != 0) return dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]];

        for (int i = 0; i < N; i++) {
            if (first == i || second == i) continue;
            if (cnt[i] == 0) continue;

            cnt[i]--;
            long val = func(second, i);
            cnt[i]++;

            if (val != -1) dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]] += val;
        }

        if (dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]] == 0) dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]] = -1;

        return dp[first][second][cnt[0]][cnt[1]][cnt[2]][cnt[3]][cnt[4]];
    }
}