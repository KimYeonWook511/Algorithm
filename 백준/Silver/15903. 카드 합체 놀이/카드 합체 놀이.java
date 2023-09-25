import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Long> pQueue = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pQueue.offer(Long.parseLong(st.nextToken()));
        }

        for (int run = 0; run < m; run++) {
            long sum = pQueue.poll() + pQueue.poll();
            pQueue.offer(sum);
            pQueue.offer(sum);
        }

        long result = 0;

        while (!pQueue.isEmpty()) {
            result += pQueue.poll();
        }

        System.out.println(result);

        br.close();
    }
}