import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String DNA = br.readLine();
        int len = DNA.length();
        int dp[][] = new int[len][len];

        for (int i = 1; i < len; i++) {
            for (int start = 0; start + i < len; start++) {
                int end = start + i;

                if (DNA.charAt(start) == 'a' && DNA.charAt(end) == 't') dp[start][end] = dp[start + 1][end - 1] + 2;
                else if (DNA.charAt(start) == 'g' && DNA.charAt(end) == 'c') dp[start][end] = dp[start + 1][end - 1] + 2;

                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][mid] + dp[mid + 1][end]);
                }
            }
        }

        System.out.println(dp[0][len - 1]);

        br.close();
    }
}