import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[N][N + 2];
        int rowCnt[] = new int[N];
        int dp[][][] = new int[3][N][N + 2]; // 0: 아래 방향, 1: 오른쪽 방향, 2: 왼쪽 방향

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 1; c <= N; c++) {
                arr[r][c] = line.charAt(c - 1) == '1';

                if (arr[r][c]) rowCnt[r]++;

                // dp 초기화
                for (int i = 0; i < 3; i++) {
                    dp[i][r][c] = 25_000_001;
                }
            }

            // dp 초기화
            dp[1][r][0] = 25_000_001;
            dp[2][r][N + 1] = 25_000_001;
        }
        
        // 첫 행
        dp[1][0][0] = 0; // 시작점
        int cnt = 0;
        for (int c = 1; c <= N; c++) {
            int r = 0;

            // 오른쪽 방향 컨베이너 벨트
            dp[1][r][c] = dp[1][r][c - 1] + 1;

            // 아래 방향 컨베이너 벨트
            if (arr[0][c]) cnt++;
            if (cnt == rowCnt[0]) dp[0][r][c] = dp[1][r][c];

            // 왼쪽 방향 컨베이너 벨트는 존재할 수 없음
        }

        // 중간
        for (int r = 1; r < N - 1; r++) {
            // 오른쪽 방향 컨베이너 벨트
            cnt = 0;
            for (int c = 1; c <= N; c++) {
                dp[1][r][c] = dp[1][r][c - 1] + 1;
                if (cnt == 0) dp[1][r][c] = Math.min(dp[1][r][c], dp[0][r - 1][c] + 1); // 머신을 지나간 경우가 없어야 위에서 내려옴
                if (dp[1][r][c] > 25_000_000) continue;

                // 아래 방향 컨베이너 벨트
                if (arr[r][c]) cnt++;
                if (cnt == rowCnt[r]) dp[0][r][c] = dp[1][r][c];
            }
            
            // 왼쪽 방향 컨베이너 벨트
            cnt = 0;
            for (int c = N; c > 0; c--) {
                dp[2][r][c] = dp[2][r][c + 1] + 1;
                if (cnt == 0) dp[2][r][c] = Math.min(dp[2][r][c], dp[0][r - 1][c] + 1); // 머신을 지나간 경우가 없어야 위에서 내려옴
                if (dp[2][r][c] > 25_000_000) continue;

                // 아래 방향 컨베이너 벨트
                if (arr[r][c]) cnt++;
                if (cnt == rowCnt[r]) dp[0][r][c] = Math.min(dp[0][r][c] , dp[2][r][c]);
            }
        }   

        // 마지막 행
        dp[0][N - 1][N] = -1; // 도착점
        cnt = 0;
        for (int c = 1; c <= N; c++) {
            int r = N - 1;

            // 오른쪽 방향 컨베이너 벨트
            dp[1][r][c] = dp[1][r][c - 1] + 1;
            if (cnt == 0) dp[1][r][c] = Math.min(dp[1][r][c], dp[0][r - 1][c] + 1); // 머신을 지나간 경우가 없어야 위에서 내려옴
            if (dp[1][r][c] > 25_000_000) continue;
            
            // 아래 방향 컨베이너 벨트
            if (arr[r][c]) cnt++;
            if (cnt == rowCnt[r]) dp[0][r][c] = dp[1][r][c];

            // 왼쪽 방향 컨베이너 벨트는 존재할 수 없음
        }

        System.out.println(dp[0][N - 1][N]);

        br.close();
    }
}