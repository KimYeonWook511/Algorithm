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
    static int dr[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dc[] = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) continue;

                deque.offer(new Node(r, c));
                visited[r][c] = true;
                boolean isTop = true;

                while (!deque.isEmpty()) {
                    Node cur = deque.poll();

                    for (int d = 0; d < 8; d++) {
                        int nr = cur.r + dr[d];
                        int nc = cur.c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= N || nc >= M) continue;

                        if (arr[nr][nc] > arr[cur.r][cur.c]) {
                            isTop = false;
                            continue;
                        }

                        if (!visited[nr][nc] && arr[nr][nc] == arr[cur.r][cur.c]) {
                            deque.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }

                if (isTop) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}