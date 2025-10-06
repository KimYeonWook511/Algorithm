import java.io.*;
import java.util.*;

public class Main {
    static class Problem {
        int P, L;
        boolean isUsed;

        Problem(int P, int L) {
            this.P = P;
            this.L = L;
            this.isUsed = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Problem> maxHeap = new PriorityQueue<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if (o1.L == o2.L) return -Integer.compare(o1.P, o2.P);

                return -Integer.compare(o1.L, o2.L);
            }
        });
        PriorityQueue<Problem> minHeap = new PriorityQueue<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if (o1.L == o2.L) return Integer.compare(o1.P, o2.P);

                return Integer.compare(o1.L, o2.L);
            }
        });

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Problem> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(P, L);

            maxHeap.offer(problem);
            minHeap.offer(problem);
            map.put(P, problem);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0); // a, r, s

            if (cmd == 'a') {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(P, L);

                maxHeap.offer(problem);
                minHeap.offer(problem);
                map.put(P, problem);

            } else if (cmd == 'r') {
                int x = Integer.parseInt(st.nextToken());
                PriorityQueue<Problem> pq = (x == 1 ? maxHeap : minHeap);

                while (!pq.isEmpty()) {
                    if (!pq.peek().isUsed) break;
                    pq.poll();
                }

                sb.append(pq.peek().P).append("\n"); // 무조건 1개 이상이 보장됨

            } else { // s
                int P = Integer.parseInt(st.nextToken());

                map.get(P).isUsed = true;
                map.remove(P); // 제거하여 이후에 solved가 또 오더라도 entries는 돌지 않음
            }
        }

        System.out.println(sb);

        br.close();
    }
}