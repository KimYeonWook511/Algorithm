import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            String M = st.nextToken();
            int len = N.length();

            int cnt0 = 0;
            int cnt1 = 0;

            for (int i = 0; i < len; i++) {
                char ch = N.charAt(i);

                if (ch == M.charAt(i)) continue;

                if (ch == '0') cnt1++;
                else cnt0++;
            }

            sb.append(Math.max(cnt0, cnt1)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}