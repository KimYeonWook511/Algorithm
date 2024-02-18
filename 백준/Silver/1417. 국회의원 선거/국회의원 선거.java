import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        
        int target = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for (int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        pq.offer(0); // 득표수는 자연수

        while (pq.peek() >= target) {
            pq.offer(pq.poll() - 1);
            target++;
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}