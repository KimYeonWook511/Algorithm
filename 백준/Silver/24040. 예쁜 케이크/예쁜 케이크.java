import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());

            if ((N % 9 == 0) || (N % 3 == 2)) sb.append("TAK\n");
            else sb.append("NIE\n");
        }

        System.out.println(sb);

        br.close();
    }
}