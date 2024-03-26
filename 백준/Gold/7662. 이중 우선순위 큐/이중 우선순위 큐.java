import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else if (!map.isEmpty()) {
                    Entry<Integer, Integer> entry = null;

                    if (num == -1) entry = map.pollFirstEntry();
                    else entry = map.pollLastEntry();

                    int val = entry.getValue() - 1;

                    if (val == 0) map.remove(entry.getKey());
                    else map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            
            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}