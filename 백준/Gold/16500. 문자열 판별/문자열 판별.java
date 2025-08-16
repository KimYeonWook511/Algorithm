import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        boolean dp[] = new boolean[S.length()];
        for (int i = S.length() - 1; i >= 0; i--) {
            for (int k = i + 1; k < S.length(); k++) {
                if (!dp[k]) continue;
                if (!set.contains(S.substring(i, k))) continue;

                dp[i] = true;
            }

            if (set.contains(S.substring(i))) dp[i] = true;
        }

        System.out.println(dp[0] ? 1 : 0);

        br.close();
    }
}