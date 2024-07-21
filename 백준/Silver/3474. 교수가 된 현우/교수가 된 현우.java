import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, cnt2, cnt5;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            cnt2 = 0;
            cnt5 = 0;

            for (int i = 2; i <= N; i *= 2) {
                cnt2 += N / i;
            }

            for (int i = 5; i <= N; i *= 5) {
                cnt5 += N / i;
            }

            sb.append(Math.min(cnt2, cnt5)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}