import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        int len = line.length();

        boolean chk[] = new boolean[len];

        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < len; i++) {
            if (line.charAt(i) == '0') cnt0++;
            else cnt1++;
        }

        cnt0 >>= 1;
        cnt1 >>= 1;

        for (int i = 0; i < len; i++) {
            if (cnt1 == 0) break;

            if (line.charAt(i) == '0') continue;

            cnt1--;
            chk[i] = true;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (cnt0 == 0) break;

            if (line.charAt(i) == '1') continue;

            cnt0--;
            chk[i] = true;
        }
        
        for (int i = 0; i < len; i++) {
            if (chk[i]) continue;

            sb.append(line.charAt(i));
        }

        System.out.println(sb);

        br.close();
    }
}