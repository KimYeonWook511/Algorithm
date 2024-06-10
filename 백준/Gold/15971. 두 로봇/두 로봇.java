import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;
        int max;

        Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static class Move {
        int i, w, max;

        Move (int i, int w, int max) {
            this.i = i;
            this.w = w;
            this.max = max;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L1 = Integer.parseInt(st.nextToken());
        int L2 = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        boolean chk[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        // 통로가 결국 N-1개라서 pq로 하는 것이 의미가 없어지는 느낌? -> 결국 남은걸 다 돌아야 함
        // -> 일반 큐를 쓰는게 더 나을거 같음
        // N개의 동굴에 N-1개의 통로면 비순환 그래프? 
        // PriorityQueue<Move> pq = new PriorityQueue<>(new Comparator<Move>() {
        //     @Override
        //     public int compare(Move o1, Move o2) {
        //         return Integer.compare(o1.w, o2.w);
        //     }
        // });

        Deque<Move> deque = new ArrayDeque<>();

        deque.offer(new Move(L1, 0, 0));
        Move cur = null;

        while (true) { // true로 해도 됨 -> 동굴은 무조건 이어져 있기 때문
            cur = deque.poll();

            chk[cur.i] = true;

            if (cur.i == L2) {
                System.out.println(cur.w - cur.max);
                break;
            }

            for (Node next : graph[cur.i]) {
                if (chk[next.i]) continue;

                deque.offer(new Move(next.i, cur.w + next.w, Math.max(cur.max, next.w)));
            }
        }

        br.close();
    }
}