import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][], END, dp[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        END = (1 << N) - 1;

        arr = new int[N][N];
        dp = new int[N][END + 1];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());

                if (arr[r][c] == 0) arr[r][c] = Integer.MAX_VALUE;
            }
        }

        System.out.println(func(1, 0));

        br.close();
    }

    static int func(int bit, int cur) {
        if (dp[cur][bit] != 0) return dp[cur][bit];

        if (bit == END) return dp[cur][bit] = arr[cur][0];

        dp[cur][bit] = Integer.MAX_VALUE;

        for (int next = 1; next < N; next++) { // 0은 시작점
            if ((bit & (1 << next)) != 0) continue; // 이미 선택함
            if (arr[cur][next] == Integer.MAX_VALUE) continue; // 갈 수 없음

            int val = func(bit | (1 << next), next);

            if (val == Integer.MAX_VALUE) continue;

            dp[cur][bit] = Math.min(dp[cur][bit], arr[cur][next] + val);
        }

        return dp[cur][bit];
    }
}