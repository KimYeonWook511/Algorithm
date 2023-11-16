import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            int max = 0;
            int min = 10000;
            
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());

                max = Math.max(max, num);
                min = Math.min(min, num);

                sum += num;
            }

            sb.append("#").append(t).append(" ").append(Math.round((sum - max - min) / (double)8)).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}