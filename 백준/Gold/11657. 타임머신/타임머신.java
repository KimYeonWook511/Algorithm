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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        long minW[] = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
        }

        minW[1] = 0; // 시작점
        for (int i = 1; i < N; i++) {
            for (int cur = 1; cur <= N; cur++) {
                if (minW[cur] == Integer.MAX_VALUE) continue;

                for (Node next : graph[cur]) {
                    minW[next.i] = Math.min(minW[next.i], minW[cur] + next.w);
                }
            }
        }

        // 음수 가중치 확인
        boolean flag = false;
        for (int cur = 1; cur <= N; cur++) {
            if (minW[cur] == Integer.MAX_VALUE) continue;

            for (Node next : graph[cur]) {
                if (minW[next.i] <= minW[cur] + next.w) continue;

                flag = true;
                cur = N;
                break;
            }
        }

        if (flag) sb.append("-1");
        else {
            for (int i = 2; i <= N; i++) {
                sb.append(minW[i] == Integer.MAX_VALUE ? "-1" : minW[i]).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
