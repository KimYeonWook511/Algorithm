import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int len = S.length();
        boolean result = true;

        char c = 0;
        for (int i = 0; i < len; i++) {
            c = S.charAt(i);

            if (c == 'p' && ++i < len && S.charAt(i) == 'i') continue;
            if (c == 'k' && ++i < len && S.charAt(i) == 'a') continue;
            if (c == 'c' && ++i < len && S.charAt(i) == 'h' && ++i < len && S.charAt(i) == 'u') continue;

            result = false;
            break;
        }

        System.out.println(result ? "YES" : "NO");

        br.close();
    }
}