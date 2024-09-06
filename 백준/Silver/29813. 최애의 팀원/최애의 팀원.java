import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            map.put(str, Integer.parseInt(st.nextToken()));
            deque.offer(str);
        }

        while (true) {
            if (deque.size() == 1) break;

            String str = deque.poll();

            for (int i = map.get(str) - 1; i > 0; i--) {
                deque.offer(deque.poll());
            }

            deque.poll();
        }

        System.out.println(deque.poll());

        br.close();
    }
}