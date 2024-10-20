import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int n, len;
        String arr[];

        for (int T = 0; T < t; T++) {
            n = Integer.parseInt(br.readLine());
            arr = new String[n];
    
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }
    
            Arrays.sort(arr);
    
            boolean result = true;
            for (int i = 1; i < n; i++) {
                len = arr[i - 1].length();

                if (arr[i].length() < len) continue;

                boolean flag = true;
                for (int k = 0; k < len; k++) {
                    if (arr[i - 1].charAt(k) != arr[i].charAt(k)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result = false;
                    break;
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}