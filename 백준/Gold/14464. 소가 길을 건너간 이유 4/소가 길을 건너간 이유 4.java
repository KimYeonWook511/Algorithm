import java.io.*;
import java.util.*;

public class Main {
    static class Cow {
        int a, b;

        Cow (int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int T[] = new int[C];
        for (int i = 0; i < C; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        Cow cows[] = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(a, b);
        }

        Arrays.sort(T);
        Arrays.sort(cows, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                int ret = Integer.compare(o1.a, o2.a);
                return ret != 0 ? ret : Integer.compare(o1.b, o2.b);
            }
        });

        PriorityQueue<Cow> pq = new PriorityQueue<>(new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                int ret = Integer.compare(o1.b, o2.b);
                return ret != 0 ? ret : Integer.compare(o1.a, o2.a);
            }
        });

        int answer = 0;
        int cowIndex = 0;
        for (int i = 0; i < C; i++) {
            // 현재 닭 시간에 맞는 소들 추가
            while (cowIndex < N && cows[cowIndex].a <= T[i]) {
                pq.offer(cows[cowIndex]);
                cowIndex++;
            }

            // 현재 닭 시점에 옮길 수 없는 소 제거
            while (!pq.isEmpty() && pq.peek().b < T[i]) {
                pq.poll();
            }

            // pq에 남아있는 소 중 가장 빨리 끝나는 소랑 현재 닭 매칭
            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}