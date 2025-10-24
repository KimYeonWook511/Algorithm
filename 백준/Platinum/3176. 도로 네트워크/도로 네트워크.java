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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Node> graph[] = new ArrayList[N + 1]; // tree
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        int LOG = 1;
        while ((1 << LOG) <= N - 1) {
            LOG++;
        }
        int next[][] = new int[LOG][N + 1];
        int min[][] = new int[LOG][N + 1];
        int max[][] = new int[LOG][N + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int depth[] = new int[N + 1];

        deque.offer(1); // root 노드를 1로 가정
        depth[1] = 1; // root 노드의 깊이는 0이지만 1로 전처리

        next[0][1] = 1; // 이건 어떻게 값을 처리해야 할까?
        min[0][1] = Integer.MAX_VALUE;
        max[0][1] = Integer.MIN_VALUE;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Node nextNode : graph[cur]) {
                if (depth[nextNode.i] != 0) continue;

                deque.offer(nextNode.i);
                depth[nextNode.i] = depth[cur] + 1;
                next[0][nextNode.i] = cur;
                min[0][nextNode.i] = nextNode.w;
                max[0][nextNode.i] = nextNode.w;
            }
        }

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                next[k][v] = next[k - 1][next[k - 1][v]];
                min[k][v] = Math.min(min[k - 1][v], min[k - 1][next[k - 1][v]]);
                max[k][v] = Math.max(max[k - 1][v], max[k - 1][next[k - 1][v]]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int answerMin = Integer.MAX_VALUE;
            int answerMax = Integer.MIN_VALUE;
            if (depth[D] < depth[E]) {
                int val[] = jump(E, depth[E] - depth[D], next, min, max);
                E = val[0];
                answerMin = val[1];
                answerMax = val[2];
            } else {
                int val[] = jump(D, depth[D] - depth[E], next, min, max);
                D = val[0];
                answerMin = val[1];
                answerMax = val[2];
            }

            if (D != E) {
                for (int k = LOG - 1; k >= 0; k--) {
                    if (next[k][D] != next[k][E]) {
                        answerMin = Math.min(answerMin, Math.min(min[k][D], min[k][E]));
                        answerMax = Math.max(answerMax, Math.max(max[k][D], max[k][E]));
                        D = next[k][D];
                        E = next[k][E];
                    }
                }

                answerMin = Math.min(answerMin, Math.min(min[0][D], min[0][E]));
                answerMax = Math.max(answerMax, Math.max(max[0][D], max[0][E]));
            }

            sb.append(answerMin).append(" ").append(answerMax).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int[] jump(int start, int bit, int next[][], int min[][], int max[][]) {
        int cur = start;
        int answerMin = Integer.MAX_VALUE;
        int answerMax = Integer.MIN_VALUE;
        for (int k = 0; k < next.length; k++) {
            if (((1 << k) & bit) != 0) {
                answerMin = Math.min(answerMin, min[k][cur]);
                answerMax = Math.max(answerMax, max[k][cur]);
                cur = next[k][cur];
            }
        }
        return new int[]{cur, answerMin, answerMax};
    }
}