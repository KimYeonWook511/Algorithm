import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 2][N + 2];
        int dp[][][] = new int[N + 2][N + 2][4];
        int max = 1;

        for (int r = 1; r <= N; r++) {
            String str = br.readLine();

            for (int c = 1; c <= N; c++) {
                arr[r][c] = str.charAt(c - 1);

                dp[r][c][0] = 1;
                dp[r][c][1] = 1;

                if (arr[r - 1][c] == arr[r][c]) dp[r][c][0] = dp[r - 1][c][0] + 1;
                if (arr[r][c - 1] == arr[r][c]) dp[r][c][1] = dp[r][c - 1][1] + 1;

                max = Math.max(max, Math.max(dp[r][c][0], dp[r][c][1]));
            }
        }

        for (int r = N; r > 0; r--) {
            for (int c = N; c > 0; c--) {
                dp[r][c][2] = 1;
                dp[r][c][3] = 1;

                if (arr[r + 1][c] == arr[r][c]) dp[r][c][2] = dp[r + 1][c][2] + 1;
                if (arr[r][c + 1] == arr[r][c]) dp[r][c][3] = dp[r][c + 1][3] + 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            // 초기화
            arr[0][i] = arr[1][i];
            arr[i][0] = arr[i][1];
        }

        for (int r = N; r > 0; r--) {
            for (int c = N; c > 0; c--) {
                if (arr[r][c] != arr[r - 1][c]) {
                    // 세로
                    if (arr[r][c] == arr[r - 2][c]) max = Math.max(max, dp[r - 2][c][0] + 1);
                    if (arr[r - 1][c] == arr[r + 1][c]) max = Math.max(max, dp[r + 1][c][2] + 1);
                    // 가로
                    if (arr[r][c] == arr[r - 1][c - 1]) max = Math.max(max, dp[r - 1][c - 1][1] + 1);
                    if (arr[r][c] == arr[r - 1][c + 1]) max = Math.max(max, dp[r - 1][c + 1][3] + 1);
                    if (arr[r - 1][c] == arr[r][c - 1]) max = Math.max(max, dp[r][c - 1][1] + 1);
                    if (arr[r - 1][c] == arr[r][c + 1]) max = Math.max(max, dp[r][c + 1][3] + 1);
                    // 가로 병합
                    if (arr[r][c] == arr[r - 1][c - 1] && arr[r][c] == arr[r - 1][c + 1]) max = Math.max(max, dp[r - 1][c - 1][1] + dp[r - 1][c + 1][3] + 1);
                    if (arr[r - 1][c] == arr[r][c - 1] && arr[r - 1][c] == arr[r][c + 1]) max = Math.max(max, dp[r][c - 1][1] + dp[r][c + 1][3] + 1);
                }

                if (arr[r][c] != arr[r][c - 1]) {
                    // 가로
                    if (arr[r][c] == arr[r][c - 2]) max = Math.max(max, dp[r][c - 2][1] + 1);
                    if (arr[r][c - 1] == arr[r][c + 1]) max = Math.max(max, dp[r][c + 1][3] + 1);
                    // 세로
                    if (arr[r][c] == arr[r - 1][c - 1]) max = Math.max(max, dp[r - 1][c - 1][0] + 1);
                    if (arr[r][c] == arr[r + 1][c - 1]) max = Math.max(max, dp[r + 1][c - 1][2] + 1);
                    if (arr[r][c - 1] == arr[r - 1][c]) max = Math.max(max, dp[r - 1][c][0] + 1);
                    if (arr[r][c - 1] == arr[r + 1][c]) max = Math.max(max, dp[r + 1][c][2] + 1);
                    // 가로 병합
                    if (arr[r][c] == arr[r - 1][c - 1] && arr[r][c] == arr[r + 1][c - 1]) max = Math.max(max, dp[r - 1][c - 1][0] + dp[r + 1][c - 1][2] + 1);
                    if (arr[r][c - 1] == arr[r - 1][c] && arr[r][c - 1] == arr[r + 1][c]) max = Math.max(max, dp[r - 1][c][0] + dp[r + 1][c][2] + 1);
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}