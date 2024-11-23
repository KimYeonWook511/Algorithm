import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int fibo[] = new int[46];
        fibo[1] = 1;

        for (int i = 2; i < 46; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[46];
            int idx = 0;

            for (int i = 45; i > 0; i--) {
                if (fibo[i] > n) continue;

                arr[idx++] = fibo[i];
                n -= fibo[i];

                if (n == 0) break;
            }

            for (int i = idx - 1; i >= 0; i--) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}