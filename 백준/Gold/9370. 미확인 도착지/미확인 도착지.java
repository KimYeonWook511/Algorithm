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
                boolean smellFlag = (a == g && b == h) || (a == h && b == g);

                graph[a].add(new Node(b, d, smellFlag));
                graph[b].add(new Node(a, d, smellFlag));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.d, o2.d);
                }
            });
            boolean visited[] = new boolean[n + 1];
            boolean smellChk[] = new boolean[n + 1];

            pq.offer(new Node(s, 0, false));
            minD[s] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (visited[cur.i]) continue;
                visited[cur.i] = true;
                cur.smellFlag = smellChk[cur.i];

                for (Node next : graph[cur.i]) {
                    if (minD[next.i] < cur.d + next.d) continue;

                    boolean nextSmellFlag = cur.smellFlag || next.smellFlag;

                    if (minD[next.i] == cur.d + next.d && (smellChk[next.i] || !nextSmellFlag)) continue;

                    minD[next.i] = cur.d + next.d;
                    smellChk[next.i] = nextSmellFlag;
                    pq.offer(new Node(next.i, cur.d + next.d, nextSmellFlag));
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());

                if (!smellChk[x]) continue;

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