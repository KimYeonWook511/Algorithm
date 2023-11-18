import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean pal = false;
            String arr[] = new String[N];

            for (int run = 0; run < N; run++) {
                String str = br.readLine();
                int len = M - 1;
                boolean flag = true;

                if (!pal) {
                    for (int i = 0; i <= len / 2; i++) {
                        if (str.charAt(i) != str.charAt(len - i)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) pal = true;
                }

                arr[run] = str;
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                String str = arr[i];

                if (str.equals("")) continue;

                for (int s = i + 1; s < N; s++) {
                    String rev = arr[s];

                    if (rev.equals("")) continue;

                    int len = M - 1;
                    boolean flag = true;

                    for (int k = 0; k <= len; k++) {
                        if (str.charAt(k) != rev.charAt(len - k)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        cnt++;
                        arr[s] = "";
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(2 * cnt * M + (pal ? M : 0)).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}