import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int run = 0; run < n; run++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                Integer val = pQueue.poll();

                if (val == null) sb.append(0).append("\n");
                else sb.append(val).append("\n");

            } else {
                pQueue.offer(num);
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}