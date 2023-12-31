import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int lenL = L.length();
        int lenR = R.length();
        int cnt = 0;

        if (lenL == lenR) {
            if (L.equals(R)) {
                for (int i = 0; i < lenL; i++) {
                    if (L.charAt(i) == '8') cnt++;
                }

            } else {
                for (int i = 0; i < lenL; i++) {
                    if (L.charAt(i) != R.charAt(i)) break;
                    if (L.charAt(i) == '8') cnt++;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}