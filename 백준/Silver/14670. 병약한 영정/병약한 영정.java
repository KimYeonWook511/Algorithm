import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int run = 0; run < N; run++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        int R = Integer.parseInt(br.readLine());
        StringBuilder tempSb;

        for (int run = 0; run < R; run++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            boolean flag = true;
            tempSb = new StringBuilder();

            for (int i = 0; i < L; i++) {
                String S = st.nextToken();

                if (!map.containsKey(S)) {
                    flag = false;
                    break;
                }

                tempSb.append(map.get(S)).append(" ");
            }

            sb.append(flag ? tempSb : "YOU DIED").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}