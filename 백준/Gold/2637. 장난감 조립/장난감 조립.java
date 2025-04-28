import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static class Node {
        int i, K;

        Node (int i, int K) {
            this.i = i;
            this.K = K;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node> graph[] = new ArrayList[N + 1];
        Map<Integer, Integer> basicMap[] = new HashMap[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            basicMap[i] = new HashMap<>();
        }

        int cnt[] = new int[N + 1]; // 선행 조건 수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph[Y].add(new Node(X, K));
            cnt[X]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] != 0) continue;

            basicMap[i].put(i, 1);
            deque.offer(i);
        }

        int result[] = new int[N + 1];
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            boolean isEnd = true;
            for (Node next : graph[cur]) {
                isEnd = false;

                for (Entry<Integer, Integer> basicPart : basicMap[cur].entrySet()) {
                    basicMap[next.i].put(basicPart.getKey(), basicMap[next.i].getOrDefault(basicPart.getKey(), 0) + (basicPart.getValue() * next.K));
                }

                if (--cnt[next.i] == 0) deque.offer(next.i);
            }

            if (!isEnd) continue;

            for (Entry<Integer, Integer> basicPart : basicMap[cur].entrySet()) {
                result[basicPart.getKey()] += basicPart.getValue();
            }
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == 0) continue;
            
            sb.append(i).append(" ").append(result[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}