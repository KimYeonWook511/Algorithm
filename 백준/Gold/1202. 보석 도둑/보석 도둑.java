import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int M, V;

        Jewel (int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Jewel> pqJewel = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                // 어차피 아래서 같은 무게 보석에 대해 가치 확인을 다시 하게 됨
                // 그래서 if문을 따로 또 안 씀
                return -Integer.compare(o1.M, o2.M);
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pqJewel.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> pqBag = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < K; i++) {
            pqBag.offer(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        long result = 0;
        Jewel cur;
        while (!pqJewel.isEmpty()) {
            cur = pqJewel.poll();

            if (pqBag.isEmpty() || cur.M > pqBag.peek()) {
                if (pq.isEmpty()) continue;
                if (pq.peek() >= cur.V) continue;
                
                result -= pq.poll();

            } else {
                pqBag.poll();
            }

            result += cur.V;
            pq.offer(cur.V);
        }

        System.out.println(result);

        br.close();
    }
}