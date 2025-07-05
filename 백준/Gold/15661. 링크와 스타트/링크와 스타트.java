import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][];
    static int result = Integer.MAX_VALUE;

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

        func(1, 1, 0, 0); // 0번은 스타트팀 고정 -> 백트래킹

        System.out.println(result);

        br.close();
    }

    static void func(int cur, int selectBit, int startTeam, int linkTeam) {
        if (cur == N) {
            result = Math.min(result, Math.abs(startTeam - linkTeam));
            return;
        }

        int startTemp = 0;
        int linkTemp = 0;
        for (int i = 0; i < cur; i++) {
            if ((selectBit & (1 << i)) > 0) startTemp += arr[cur][i] + arr[i][cur];
            else linkTemp += arr[cur][i] + arr[i][cur];
        }

        // 선택 -> 스타트팀
        func(cur + 1, selectBit | (1 << cur), startTeam + startTemp, linkTeam);

        // 미선택 -> 링크팀
        func(cur + 1, selectBit, startTeam, linkTeam + linkTemp);
    }
}