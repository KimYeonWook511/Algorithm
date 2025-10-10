import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0;
        int right = 200;
        while (left <= right) {
            int gap = (left + right) / 2;

            boolean flag = false;
            for (int max = gap; max <= 200; max++) {
                if (bfs(n, arr, max - gap, max)) {
                    flag = true;
                    break;
                }
            }

            if (flag) right = gap - 1;
            else left = gap + 1;
        }

        System.out.println(left);

        br.close();
    }

    static boolean bfs(int n, int arr[][], int min, int max) {
        if (arr[0][0] < min || arr[0][0] > max) return false;

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n];
        deque.offer(new Node(0, 0));
        visited[0][0] = true;

        boolean flag = false;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == n - 1 && cur.c == n - 1) {
                flag = true;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= n || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] < min || arr[nr][nc] > max) continue;

                deque.offer(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return flag;
    }
}