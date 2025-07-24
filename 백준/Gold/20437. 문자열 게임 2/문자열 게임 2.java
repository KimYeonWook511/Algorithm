import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int alphabet[] = new int[26];
            for (int i = 0; i < W.length(); i++) {
                alphabet[W.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < W.length(); i++) {
                char ch = W.charAt(i);

                if (alphabet[ch - 'a'] < K) continue;
 
                int len = 1;
                for (int k = i + 1; k < W.length(); k++) {
                    if (ch != W.charAt(k)) continue;

                    if (++len == K) {
                        min = Math.min(min, k - i + 1);
                        max = Math.max(max, k - i + 1);
                        break;
                    }
                }
            }

            if (max == 0) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}