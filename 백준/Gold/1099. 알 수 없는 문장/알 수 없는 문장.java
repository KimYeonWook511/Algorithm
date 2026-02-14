import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        String words[] = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int dp[] = new int[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            dp[i] = INF;
        }

        for (int i = 0; i < str.length(); i++) {
            if (dp[i] == INF) continue;

            for (String word : words) {
                int L = word.length();
                if (i + L > str.length()) continue;

                String sub = str.substring(i, i + L);

                if (check(sub, word)) {
                    dp[i + L] = Math.min(dp[i + L], dp[i] + calcCost(sub, word));
                }
            }
        }

        System.out.println(dp[str.length()] == INF ? -1 : dp[str.length()]);

        br.close();
    }

    static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;

        int cnt[] = new int[26];

        for (char c : a.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            cnt[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }

        return true;
    }

    static int calcCost(String a, String b) {
        int cost = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cost++;
            }
        }
        return cost;
    }
}
