import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt[] = new int[53];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        String line = br.readLine();
        char c = 0;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            c = line.charAt(i);

            if (c == ' ') {
                if (--cnt[0] >= 0) continue;

                flag = false;
                break;
            }

            if (c >= 'A' && c <= 'Z') {
                if (--cnt[c - 'A' + 1] >= 0) continue;

                flag = false;
                break;
            }

            if (--cnt[c - 'a' + 27] >= 0) continue;

            flag = false;
            break;
        }

        System.out.println(flag ? "y" : "n");

        br.close();
    }
}