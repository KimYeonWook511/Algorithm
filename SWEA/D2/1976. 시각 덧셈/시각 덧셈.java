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

            int m = Integer.parseInt(st.nextToken()) * 60;
            m += Integer.parseInt(st.nextToken());
            m += Integer.parseInt(st.nextToken()) * 60;
            m += Integer.parseInt(st.nextToken());

            int h = (m / 60 - 1) % 12 + 1;
            m %= 60;

            sb.append("#").append(t).append(" ").append(h).append(" ").append(m).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}