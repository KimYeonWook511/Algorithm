import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String result[];
        int idx = 0;
        double max = 0;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            result = new String[N];
            idx = 0;
            max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double val = Double.parseDouble(st.nextToken());

                if (val == max) result[idx++] = name;
                else if (val > max) {
                    max = val;
                    result[0] = name;
                    idx = 1;
                }
            }

            for (int i = 0; i < idx; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}