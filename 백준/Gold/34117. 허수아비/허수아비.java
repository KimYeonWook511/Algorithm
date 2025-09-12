import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            pq.offer(num);
            sum += num;

            int result = -1;
            while (sum >= P) {
                if (sum - pq.peek() < P) {
                    result = pq.size();
                    break;
                }

                sum -= pq.poll();
            }

            sb.append(result).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}