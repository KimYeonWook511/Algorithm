import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String code = "";

            for (int r = 0; r < N; r++) {
                String str = br.readLine();

                if (code.equals("") && str.contains("1")) {
                    code = str;
                }
            }

            for (int i = M - 1; i >= 0; i--) {
                char c = code.charAt(i);

                if (c == '1') {
                    code = code.substring(i - 55, i + 1);
                    break;
                }
            }

            int odd = 0;
            int even = 0;

            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) odd += map.get(code.substring(i * 7, i * 7 + 7));
                else even += map.get(code.substring(i * 7, i * 7 + 7));
            }

            int result = odd * 3 + even;

            sb.append("#").append(t).append(" ").append(result % 10 == 0 ? odd + even : 0).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}