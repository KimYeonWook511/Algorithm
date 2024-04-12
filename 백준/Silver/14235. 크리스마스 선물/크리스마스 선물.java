import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                sb.append(pq.isEmpty() ? "-1" : pq.poll()).append("\n");
                continue;
            }

            for (int i = 0; i < a; i++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);

        br.close();
    }
}