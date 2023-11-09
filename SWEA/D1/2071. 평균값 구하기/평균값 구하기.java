import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(Math.round(sum / (double)10)).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}