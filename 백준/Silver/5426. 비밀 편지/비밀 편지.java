import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String line;
        int sqrt;

        for (int t = 0; t < T; t++) {
            line = br.readLine();
            sqrt = (int)Math.sqrt(line.length());

            for (int i = 1; i <= sqrt; i++) {
                for (int k = 1; k <= sqrt; k++) {
                    sb.append(line.charAt(sqrt * k - i));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}