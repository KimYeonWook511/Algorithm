import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            for (int j = i + 1; j < N; j++) {
                if (check(str.charAt(i), str.charAt(j))) {
                    dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                }
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);

        br.close();
    }

    static boolean check(char a, char b) {
        if (a == 'B' && b == 'O') return true;
        if (a == 'O' && b == 'J') return true;
        if (a == 'J' && b == 'B') return true;
        return false;
    }
}
