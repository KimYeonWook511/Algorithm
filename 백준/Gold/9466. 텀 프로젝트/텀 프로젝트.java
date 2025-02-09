import java.io.*;
import java.util.*;

public class Main {
    static int n, arr[];
    static int chk[], cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            chk = new int[n + 1];
            int result = 0;

            for (int i = 1; i <= n; i++) {
                cnt = 0;
                func(i);
                result += cnt;
            }

            sb.append(result).append("\n");
        }
        
        System.out.println(sb);

        br.close();
    }

    static int func(int cur) {
        if (chk[cur] != 0) return cur;

        chk[cur] = -1;
        chk[cur] = func(arr[cur]);

        if (cur == chk[cur]) cnt = 0;
        else cnt++;

        return chk[cur];
    }
}