import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int mod[] = {2, 3, 5, 7, 11};

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int cnt[] = new int[5];

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < 5; i++) {
                while (N % mod[i] == 0) {
                    cnt[i]++;
                    N /= mod[i];
                }

                sb.append(cnt[i]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}