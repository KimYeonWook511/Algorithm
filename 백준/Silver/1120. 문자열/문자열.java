import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int min = 50;

        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int cnt = 0;

            for (int p = 0; p < a.length(); p++) {
                if (a.charAt(p) != b.charAt(p + i)) cnt++;
            }

            min = Math.min(min, cnt);
        }

        System.out.println(min);

        br.close();
    }
}