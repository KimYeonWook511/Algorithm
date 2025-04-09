import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());

            int D = (-1 + (int)Math.sqrt(1 + 8 * N)) >> 1;

            sb.append(D).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}