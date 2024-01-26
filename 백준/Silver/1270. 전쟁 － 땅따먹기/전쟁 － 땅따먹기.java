import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            String maxKey = "";

            for (int i = 0; i < T; i++) {
                String key = st.nextToken();
                Integer value = map.put(key, map.getOrDefault(key, 0) + 1);
                
                value = value == null ? 1 : value + 1;

                if (value > max) {
                    max = value;
                    maxKey = key;
                }
            }

            if (max > T / 2) sb.append(maxKey).append("\n");
            else sb.append("SYJKGW").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}