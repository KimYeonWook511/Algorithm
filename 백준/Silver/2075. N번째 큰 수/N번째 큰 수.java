import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            pQueue.offer(Integer.parseInt(st.nextToken()));
        }

        for (int run = 1; run < n; run++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                pQueue.offer(Integer.parseInt(st.nextToken()));

                pQueue.poll();
            }
        }

        System.out.println(pQueue.poll());

        br.close();
    }
}