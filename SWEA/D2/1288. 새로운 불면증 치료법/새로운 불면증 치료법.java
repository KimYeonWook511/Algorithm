import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int tempN = N;

            boolean chk[] = new boolean[10];
            int cnt = 10;
            
            while (cnt > 0) {
                String str = Integer.toString(tempN);
                int len = str.length();
                
                for (int i = 0; i < len; i++) {
                    int idx = str.charAt(i) - '0';

                    if (!chk[idx]) {
                        chk[idx] = true;
                        cnt--;
                    }
                }

                tempN += N;
            }

            sb.append("#").append(t).append(" ").append(tempN - N).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}