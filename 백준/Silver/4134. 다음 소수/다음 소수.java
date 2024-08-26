import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());

            if (n < 3) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                boolean flag = true;

                int sqrt = (int)Math.sqrt(n);
                for (int i = 2; i <= sqrt; i++) {
                    if (n % i != 0) continue;

                    flag = false;
                    break;
                }

                if (flag) {
                    sb.append(n).append("\n");
                    break;
                }

                n++;
            }
        }

        System.out.println(sb);

        br.close();
    }
}