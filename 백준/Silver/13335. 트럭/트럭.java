import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        int arr[] = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < w; i++) {
            deque.offer(0);
        }

        int idx = 0;
        int time = 0;
        int weight = 0;

        while (!deque.isEmpty()) {
            time++;
            weight -= deque.poll();

            if (idx >= n) continue;

            if (arr[idx] + weight > L) {
                deque.offer(0);
                continue;
            }

            weight += arr[idx];
            deque.offer(arr[idx]);
            idx++;
        }

        System.out.println(time);

        br.close();
    }
}