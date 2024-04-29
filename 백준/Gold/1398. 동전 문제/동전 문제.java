import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int dp[] = new int[101];
        
        for (int i = 1; i <= 100; i++) {
        	if (i < 10) dp[i] = i;
        	else if (i < 25) dp[i] = 1 + dp[i - 10];
        	else dp[i] = Math.min(1 + dp[i - 10], 1 + dp[i - 25]);
        }

        for (int run = 0; run < T; run++) {
            String str = br.readLine();
            int len = str.length();

            int startIdx = 0;
            int cnt = 0;

            if (len % 2 == 1) {
                cnt += dp[str.charAt(0) - '0'];
                startIdx = 1;
            }
            
            for (int i = startIdx; i < len; i += 2) {
                cnt += dp[(str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0')];
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}