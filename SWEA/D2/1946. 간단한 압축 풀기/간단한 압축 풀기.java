import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int len = 0;

            sb.append("#").append(t).append("\n");

            for (int run = 0; run < N; run++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                for (int i = 0; i < n; i++) {
                    if (len == 10) {
                        sb.append("\n");
                        len = 0;
                    }

                    sb.append(c);
                    len++;
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}