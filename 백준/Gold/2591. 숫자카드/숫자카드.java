import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int dp[] = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

		for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i];

            int num1 = (str.charAt(i - 1) - '0') * 10;
            int num2 = str.charAt(i) - '0';
            int sum = num1 + num2;

            if (num2 == 0) dp[i + 1] -= dp[i];
            if (num1 != 0 && sum >= 1 && sum <= 34) dp[i + 1] += dp[i - 1];
		}

		System.out.println(dp[len]);

        br.close();
    }
}