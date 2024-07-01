import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> idxMap = new HashMap<>();
        int cnt[][] = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();

            strMap.put(name, i);
            idxMap.put(i, name);
            cnt[i][0] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                cnt[strMap.get(st.nextToken())][1]++;
            }
        }

        Arrays.sort(cnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return idxMap.get(o1[0]).compareTo(idxMap.get(o2[0]));

                return -Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(idxMap.get(cnt[i][0])).append(" ").append(cnt[i][1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}