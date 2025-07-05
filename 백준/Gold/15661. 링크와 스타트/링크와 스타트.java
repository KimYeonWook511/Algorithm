import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][];
    static int result = Integer.MAX_VALUE;
    static int fullSelectBit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        fullSelectBit = (1 << N) - 1; // 한 쪽 팀으로 되는 경우 빼기
        func(1, 1); // 0번은 스타트팀 고정 -> 백트래킹

        System.out.println(result);

        br.close();
    }

    static void func(int cur, int selectBit) {
        if (cur == N) {
            if (selectBit != fullSelectBit) cal(selectBit);

            return;
        }

        // 선택 -> 스타트팀
        func(cur + 1, selectBit | (1 << cur));

        // 미선택 -> 링크팀
        func(cur + 1, selectBit);
    }

    static void cal(int startTeamBit) {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            boolean isStartTeam = (startTeamBit & (1 << i)) > 0;

            for (int k = i + 1; k < N; k++) {
                if (isStartTeam && (startTeamBit & (1 << k)) > 0) startTeam += arr[i][k] + arr[k][i];
                else if (!isStartTeam && (startTeamBit & (1 << k)) == 0) linkTeam += arr[i][k] + arr[k][i];
            }
        }

        result = Math.min(result, Math.abs(startTeam - linkTeam));
    }
}