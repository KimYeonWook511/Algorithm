import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long sum = 0;

        for (int run = 0; run < Q; run++) {
            st = new StringTokenizer(br.readLine());
            String name = "";
            PriorityQueue<Integer> pq;

            if (st.nextToken().charAt(0) == '1') {
                name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());

                pq = map.getOrDefault(name, new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -Integer.compare(o1, o2);
                    }
                }));

                for (int i = 0; i < k; i++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }

                map.put(name, pq);

            } else {
                name = st.nextToken();

                int b = Integer.parseInt(st.nextToken());
                pq = map.getOrDefault(name, null);

                if (pq == null) continue;

                for (int i = 0; i < b; i++) {
                    if (pq.isEmpty()) break;

                    sum += pq.poll();
                }
            }
        }

        System.out.println(sum);

        br.close();
    }
}