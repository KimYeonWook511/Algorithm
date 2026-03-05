import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        boolean isBlue;

        Node (int num, boolean isBlue) {
            this.num = num;
            this.isBlue = isBlue;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> graph[] = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int k = 0; k < count; k++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i].add(num);
            }
        }

        List<Integer> blueTeam = new ArrayList<>();
        List<Integer> whiteTeam = new ArrayList<>();

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            deque.add(new Node(i, true));
            visited[i] = true;
            while (!deque.isEmpty()) {
                Node cur = deque.poll();

                if (cur.isBlue) {
                    blueTeam.add(cur.num);
                } else {
                    whiteTeam.add(cur.num);
                }

                for (int next : graph[cur.num]) {
                    if (visited[next]) continue;

                    deque.add(new Node(next, !cur.isBlue));
                    visited[next] = true;
                }
            }
        }

        Collections.sort(blueTeam);
        Collections.sort(whiteTeam);

        StringBuilder sb = new StringBuilder();
        sb.append(blueTeam.size()).append("\n");
        for (int num : blueTeam) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
        sb.append(whiteTeam.size()).append("\n");
        for (int num : whiteTeam) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}