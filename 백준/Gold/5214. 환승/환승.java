import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, cnt;

        Node (int i, int cnt) {
            this.i = i;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new List[N + 1]; // index가 속하는 tube
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int tubes[][] = new int[M][K];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++) {
                int index = Integer.parseInt(st.nextToken());
                graph[index].add(m);
                tubes[m][k] = index;
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean graphVisited[] = new boolean[N + 1];
        boolean tubeVisited[] = new boolean[M];
        deque.offer(new Node(1, 1));
        graphVisited[1] = true;

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.i == N) {
                answer = cur.cnt;
                break;
            }

            for (int tube : graph[cur.i]) {
                if (tubeVisited[tube]) continue;

                tubeVisited[tube] = true;
                for (int next : tubes[tube]) {
                    if (!graphVisited[next]) {
                        deque.offer(new Node(next, cur.cnt + 1));
                        graphVisited[next] = true;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}