import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][M];
        boolean chk[][] = new boolean[N][M]; // 방문 여부

        int val[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("0")) arr[i][j] = true;
            }
        }

        while (true) {
            if (r < 0 || c < 0) break;
            if (r >= N || c >= M) break;
            if (!arr[r][c]) break;

            if (!chk[r][c]) {
                cnt++;
                chk[r][c] = true;
            }

            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + val[d][0]; 
                int nc = c + val[d][1];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (chk[nr][nc]) continue;
                if (!arr[nr][nc]) continue;

                r = nr;
                c = nc;
                flag = true;
                break;
            }

            if (flag) continue;

            r += val[(d + 2) % 4][0];
            c += val[(d + 2) % 4][1];
        }

        System.out.println(cnt);

        br.close();
    }
}