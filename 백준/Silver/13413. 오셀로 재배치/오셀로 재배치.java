import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();

            int B1 = 0;
            int B2 = 0;
            int notMatch = 0;

            for (int i = 0; i < N; i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);

                if (c1 == 'B') B1++;
                if (c2 == 'B') B2++;
                if (c1 != c2) notMatch++;
            }

            int cnt = Math.abs(B1 - B2);
            cnt += (notMatch - cnt) / 2;

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}