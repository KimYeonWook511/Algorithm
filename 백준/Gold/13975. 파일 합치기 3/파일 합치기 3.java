import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (pq.size() != 1) {
                long sum = pq.poll() + pq.poll();

                result += sum;
                pq.offer(sum);
            }

            pq.poll();
            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}