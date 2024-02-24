import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            char str1[] = st.nextToken().toCharArray();
            char str2[] = st.nextToken().toCharArray();
            int len1 = str1.length;
            int len2 = str2.length;

            int dp[][] = new int[len1 + 1][len2 + 1];

            for (int r = 1; r <= len1; r++) {
                for (int c = 1; c <= len2; c++) {
                    if (str1[r - 1] == str2[c - 1]) dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c - 1] + 1);
                    else dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]);
                }
            }

            sb.append("#").append(t).append(" ").append(dp[len1][len2]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}