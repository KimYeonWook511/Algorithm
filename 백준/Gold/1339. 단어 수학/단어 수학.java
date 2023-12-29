import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt[] = new int[26];

        for (int run = 0; run < N; run++) {
            String str = br.readLine();

            int len = str.length();

            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);

                cnt[c - 'A'] += Math.pow(10, len - i - 1);
            }
        }
        
        int max = 0;
        int maxIdx = 0;
        int sum = 0;

        for (int run = 0; run < 10; run++) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    maxIdx = i;
                }
            }

            if (max == 0) break;

            sum += max * (9 - run);
            cnt[maxIdx] = 0;
            max = 0;
        }

        System.out.println(sum);

        br.close();
    }
}