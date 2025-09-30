import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;

        Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static class Fox extends Node {
        Fox(int i, int w) {
            super(i, w);
        }
    }

    static class Wolf extends Node {
        int turn;

        Wolf(int i, int w, int turn) {
            super(i, w);
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        int minWFox[] = new int[N + 1];
        int minWWolf[][] = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            minWFox[i] = Integer.MAX_VALUE;
            minWWolf[i][0] = Integer.MAX_VALUE;
            minWWolf[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2; // 2의 배수로 보정

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        dijkFox(N, graph, minWFox);
        dijkWolf(N, graph, minWWolf);

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (minWFox[i] < minWWolf[i][0] && minWFox[i] < minWWolf[i][1]) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    static void dijkFox(int N, List<Node> graph[], int minW[]) {
        PriorityQueue<Fox> pq = new PriorityQueue<>(new Comparator<Fox>() {
            @Override
            public int compare(Fox o1, Fox o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];
        pq.offer(new Fox(1, 0));
        minW[1] = 0;

        while (!pq.isEmpty()) {
            Fox cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;
                if (minW[next.i] <= cur.w + next.w) continue;

                pq.offer(new Fox(next.i, cur.w + next.w));
                minW[next.i] = cur.w + next.w;
            }
        }
    }

    static void dijkWolf(int N, List<Node> graph[], int minW[][]) {
        PriorityQueue<Wolf> pq = new PriorityQueue<>(new Comparator<Wolf>() {
            @Override
            public int compare(Wolf o1, Wolf o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[][] = new boolean[N + 1][2];
        pq.offer(new Wolf(1, 0, 0));
        minW[1][0] = 0; // [1][1]은 하면 안 됨! -> 1번 노드 출발이 짝수 턴일 때가 최선일 수 있음

        while (!pq.isEmpty()) {
            Wolf cur = pq.poll();

            if (visited[cur.i][cur.turn]) continue;
            visited[cur.i][cur.turn] = true;

            int nt = (cur.turn + 1) % 2;
            for (Node next : graph[cur.i]) {
                if (visited[next.i][nt]) continue;

                int dist = cur.w + (cur.turn == 0 ? next.w / 2 : next.w * 2);
                if (minW[next.i][nt] <= dist) continue;

                pq.offer(new Wolf(next.i, dist, nt));
                minW[next.i][nt] = dist;
            }
        }
    }
}