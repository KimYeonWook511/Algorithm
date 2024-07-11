import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = 0;
        int t = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            Map<Integer, String> map = new HashMap<>();
            boolean chk[] = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                map.put(i, br.readLine());
            }

            for (int i = (n << 1) - 1; i > 0; i--) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());

                chk[idx] = !chk[idx]; 
            }

            for (int i = 1; i <= n; i++) {
                if (!chk[i]) continue;

                sb.append(t++).append(" ").append(map.get(i)).append("\n");
                break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}