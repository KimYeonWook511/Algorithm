import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        double ac = 0;
        double total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            String userId = st.nextToken();

            if ("megalusion".equals(userId)) continue;

            int val = map.getOrDefault(userId, 0);
            if (val < 0) continue;
            val++;

            int result = Integer.parseInt(st.nextToken());

            if (result == 4) {
                ac++;
                total += val;
                val *= -1;
            }

            map.put(userId, val);
        }

        if (total == 0) System.out.println(0);
        else System.out.println(ac / total * 100);

        br.close();
    }
}