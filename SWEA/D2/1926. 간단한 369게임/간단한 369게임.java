import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = i;
            int cnt = 0;

            while (num > 0) {
                int mod = num % 10;
    
                if (mod == 3 || mod == 6 || mod == 9) cnt++;

                num /= 10;
            }

            if (cnt == 0) {
                sb.append(i);

            } else {
                for (int k = 0; k < cnt; k++) {
                    sb.append("-");
                }
            }

            sb.append(" ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}