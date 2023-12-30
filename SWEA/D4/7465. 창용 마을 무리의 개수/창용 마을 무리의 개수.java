import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static boolean arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new boolean[N + 1][N + 1];

            int group = 0;

            for (int run = 0; run < M; run++) {
                st = new StringTokenizer(br.readLine());

                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                arr[right][left] = true;
                arr[left][right] = true;
            }

            for (int r = 1; r <= N; r++) {
                arr[r][r] = true;
            }

            for (int r = 1; r <= N; r++) {
                if (!arr[r][0]) {
                    group++;
                    func(r);
                }

                if (arr[r][r]) group++;
            }

            sb.append("#").append(t).append(" ").append(group).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int r) {
        if (arr[r][0]) return;

        arr[r][0] = true; // 검색함

        for (int c = 1; c <= N; c++) {
            if (arr[r][c]) {
                arr[r][c] = false;
                func(c);
            }
        }
    }
}