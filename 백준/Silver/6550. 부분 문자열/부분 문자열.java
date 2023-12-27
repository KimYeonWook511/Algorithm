import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = "";
        String s = "";
        String t = "";

        int idx = 0;
        int sLen = 0;
        int tLen = 0;

        while (true) {
            str = br.readLine();

            if (str == null) break;

            st = new StringTokenizer(str);

            s = st.nextToken();
            t = st.nextToken();

            idx = 0;
            sLen = s.length();
            tLen = t.length();

            for (int i = 0; i < tLen; i++) {
                if (s.charAt(idx) == t.charAt(i)) {
                    idx++;

                    if (idx == sLen) break;
                }
            }

            if (idx == sLen) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}