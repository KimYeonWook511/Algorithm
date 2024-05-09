import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                String x = st.nextToken();
                map.put(st.nextToken(), x);

            } else {
                sb.append(map.get(st.nextToken())).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}