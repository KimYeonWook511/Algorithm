import java.io.*;
import java.util.*;

public class Solution {
    static int N, arr[][], min;
    static boolean chk[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N + 2][2];
            chk = new boolean[N + 2];
            min = 2200;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            func(0, 0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int cnt, int preIdx, int sum) {
        if (cnt == N) {
            min = Math.min(min, sum + Math.abs(arr[preIdx][0] - arr[1][0]) + Math.abs(arr[preIdx][1] - arr[1][1]));
            return;
        }

        for (int i = 2; i < N + 2; i++) {
            if (chk[i]) continue;

            chk[i] = true;
            func(cnt + 1, i, sum + Math.abs(arr[preIdx][0] - arr[i][0]) + Math.abs(arr[preIdx][1] - arr[i][1]));
            chk[i] = false;
        }
    }
}