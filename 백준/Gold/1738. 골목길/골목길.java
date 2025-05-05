import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int s, e, w;

        Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int maxW[] = new int[n + 1];
        int preIdx[] = new int[n + 1];
        List<Integer> revGraph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            maxW[i] = Integer.MIN_VALUE;
            revGraph[i] = new ArrayList<>();
        }

        Edge edgeArr[] = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeArr[i] = new Edge(u, v, w);
            revGraph[v].add(u);
        }

        maxW[1] = 0; // 민승이 집
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < m; k++) {
                Edge cur = edgeArr[k];

                if (maxW[cur.s] == Integer.MIN_VALUE) continue;

                int sum = maxW[cur.s] + cur.w;

                if (maxW[cur.e] < sum) {
                    maxW[cur.e] = sum;
                    preIdx[cur.e] = cur.s;
                }
            }
        }
        
        boolean isCan[] = new boolean[n + 1]; // n에 도달 가능한 정점
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(n);
        isCan[n] = true;

        // n에 도달 가능한 정점 체크
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int pre : revGraph[cur]) {
                if (isCan[pre]) continue;

                deque.offer(pre);
                isCan[pre] = true;
            }
        }

        boolean flag = preIdx[n] == 0; // 코레스트 콘도에 도착 불가능
        if (!flag) {
            // 사이클 있는지 확인
            // 그냥 사이클만 있어선 안 될듯 -> 해당 사이클이 도착점까지 도달 가능해야함
            for (int k = 0; k < m; k++) {
                Edge cur = edgeArr[k];
    
                if (maxW[cur.s] == Integer.MIN_VALUE) continue;
    
                if (maxW[cur.e] < maxW[cur.s] + cur.w && isCan[cur.e]) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) sb.append("-1");
        else {
            List<Integer> result = new ArrayList<>();

            int cur = n;
            while (cur != 0) {
                result.add(cur);
                cur = preIdx[cur];
            }

            for (int i = result.size() - 1; i >= 0; i--) {
                sb.append(result.get(i)).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}