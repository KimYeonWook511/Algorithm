import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int cnt = 0;
        int sum = 0;

        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);

            if (c != str.charAt(i - 1)) continue;

            if (c == '(') cnt++;
            else sum += cnt;
        }

        System.out.println(sum);

        br.close();
    }
}