import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N != 0) {
            while (true) {
                if (N == 1) break;

                sb.append(Math.abs(N % -2));
                N = (int)Math.ceil(N / -2.0);
            }
        }

        sb.append(N);

        System.out.println(sb.reverse());

        br.close();
    }
}