import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N != 1) {
            String str = Integer.toString(N);
            int len = str.length() - 1;

            boolean flag = false;

            for (int i = len / 2; i >= 0; i--) {
                if (str.charAt(i) != str.charAt(len - i)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                N++;
                continue;
            }

            for (int i = 2; i * i <= N; i++) {
                if (N % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                N++;
                continue;
            }

            break;
        }

        System.out.println(N == 1 ? 2 : N);
    }
}