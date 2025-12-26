import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String before = br.readLine();
        String after = br.readLine();

        int prefix = 0;
        while (prefix < before.length() && prefix < after.length()) {
            if (before.charAt(prefix) != after.charAt(prefix)) break;
            prefix++;
        }

        int suffix = 0;
        while (suffix < before.length() && suffix < after.length()) {
            if (before.charAt(before.length() - 1 - suffix) != after.charAt(after.length() - 1 - suffix)) break;
            suffix++;
        }

        // 보정
        int maxKeep = Math.min(prefix + suffix, Math.min(before.length(), after.length()));
        int answer = after.length() - maxKeep;

        System.out.println(answer);
    }
}
