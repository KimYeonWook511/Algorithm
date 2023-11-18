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

            int v = 0;
            int m = 0;

            for (int run = 0; run < N; run++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);

                if (c == '1') v += Integer.parseInt(st.nextToken());
                else if (c == '2') v = Math.max(v - Integer.parseInt(st.nextToken()), 0);
                
                m += v;
            }

            sb.append("#").append(t).append(" ").append(m).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}