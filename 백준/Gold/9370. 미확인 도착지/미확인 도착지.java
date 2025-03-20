import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, d;
        boolean smellFlag;

        Node (int i, int d, boolean smellFlag) {
            this.i = i;
            this.d = d;
            this.smellFlag = smellFlag;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        StringBuilder tcSb;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            tcSb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<Node> graph[] = new ArrayList[n + 1];
            int minD[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                minD[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, d, false));
                graph[b].add(new Node(a, d, false));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.d == o2.d) return (o1.smellFlag || !o2.smellFlag) ? -1 : 1;

                    return Integer.compare(o1.d, o2.d);
                }
            });
            boolean chk[] = new boolean[n + 1];

            pq.offer(new Node(s, 0, false));
            minD[s] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (chk[cur.i]) continue;
                chk[cur.i] = true;

                // 이 부분은 poll했을 때 갱신하려다가 next를 삽입하는 과정에서 처리해줘야 하는 로직으로 수정함
                // if (!cur.smellFlag) minD[cur.i] = -minD[cur.i]; // JVM은 내부적으로 2의 보수로 동작함, -1을 곱하는 것은 더 비효율적

                for (Node next : graph[cur.i]) {
                    if (Math.abs(minD[next.i]) < cur.d + next.d) continue;
                    if (minD[next.i] > 0 && minD[next.i] == cur.d + next.d) continue;

                    boolean nextSmellFlag = cur.smellFlag || (cur.i == g && next.i == h) || (cur.i == h && next.i == g);

                    if (!nextSmellFlag && -minD[next.i] == cur.d + next.d) continue;

                    minD[next.i] = nextSmellFlag ? cur.d + next.d : -(cur.d + next.d);
                    pq.offer(new Node(next.i, cur.d + next.d, nextSmellFlag));
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());

                if (minD[x] == Integer.MAX_VALUE || minD[x] <= 0) continue;

                result.add(x);
            }

            Collections.sort(result);
            for (int x : result) {
                tcSb.append(x).append(" ");
            }

            sb.append(tcSb).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}