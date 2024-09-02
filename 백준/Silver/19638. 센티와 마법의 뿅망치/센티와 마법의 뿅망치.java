import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < T; i++) {
            if (pq.peek() < H) break;
            if (pq.peek() <= 1) break;

            pq.add(pq.poll() / 2);
            cnt++;
        }

        System.out.println(pq.peek() < H ? "YES\n" + cnt : "NO\n" + pq.peek());

        br.close();
    }
}