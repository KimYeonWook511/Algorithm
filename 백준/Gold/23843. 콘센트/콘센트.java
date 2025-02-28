import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = N - 1; i >= 0; i--) {
            pq.offer((pq.size() >= M ? pq.poll() : 0) + arr[i]);
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result = pq.poll();
        }

        System.out.println(result);

        br.close();
    }
}