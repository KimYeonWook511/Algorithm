import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int len = input.length();

            int depth = 0;
            int max = 0;

            for (int i = 0; i < len; i++) {
                char ch = input.charAt(i);

                if (ch == '[') depth++;
                else depth--;

                max = Math.max(max, depth);
            }

            sb.append(1 << max).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}