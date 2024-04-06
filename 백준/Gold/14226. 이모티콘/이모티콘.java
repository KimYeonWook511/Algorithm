import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int dp[] = new int[(S << 1) + 1];

        for (int i = S << 1; i >= 2; i--) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int clip = 1; clip <= S; clip++) {
            int i = 2;
            int next = clip << 1;

            while (next <= S << 1) {
                dp[next] = Math.min(dp[next], dp[clip] + i);
                dp[next - 1] = Math.min(dp[next - 1], dp[next] + 1);

                next += clip;
                i++;
            }
        }

        System.out.println(dp[S]);

        br.close();
    }
}