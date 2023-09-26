import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        long result = 0;

        int n = Integer.parseInt(br.readLine());

        for (int run = 0; run < n; run++) {
            pQueue.offer(Long.parseLong(br.readLine()));
        }

        while (pQueue.size() > 1) {
            long sum = pQueue.poll() + pQueue.poll();

            result += sum;

            pQueue.offer(sum);
        }

        System.out.println(result);

        br.close();
    }
}