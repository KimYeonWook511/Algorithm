import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int len = str.length();
            boolean flag = true;
            
            for (int i = 0; i <= (len - 1) / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) flag = false;
            }

            sb.append("#").append(t).append(" ").append(flag ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}