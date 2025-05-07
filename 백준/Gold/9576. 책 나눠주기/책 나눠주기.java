import java.io.*;
import java.util.*;

public class Main {
    static int arr[][], chkIdx[];
    static boolean chk[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[M + 1][2];
            chkIdx = new int[N + 1];
            int cnt = 0;

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i][0] = a;
                arr[i][1] = b;

                chk = new boolean[N + 1];
                if (dfs(i)) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static boolean dfs(int cur) {
        int s = arr[cur][0];
        int e = arr[cur][1];

        for (; s <= e; s++) {
            if (chk[s]) continue;

            chk[s] = true;
            if (chkIdx[s] == 0 || dfs(chkIdx[s])) {
                chkIdx[s] = cur;
                return true;
            }
        }

        return false;
    }
}