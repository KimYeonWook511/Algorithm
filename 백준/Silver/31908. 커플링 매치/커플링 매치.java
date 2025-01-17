import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        String arr[][] = new String[N][2];
        int size[] = new int[N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String s = st.nextToken();

            if (s.charAt(0) == '-') continue;

            if (!map.containsKey(s)) map.put(s, idx++);
            int index = map.get(s);

            size[index]++;

            if (size[index] > 2) continue;

            arr[index][arr[index][0] == null ? 0 : 1] = p;
        }

        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            if (size[i] != 2) continue;

            cnt++;
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(cnt);
        System.out.println(sb);

        br.close();
    }
}