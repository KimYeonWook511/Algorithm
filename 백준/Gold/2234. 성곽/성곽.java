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
    static int dr[] = {0, -1, 0, 1};
    static int dc[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[M][N];
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result[] = new int[3];
        Deque<Node> deque = new ArrayDeque<>();
        int chk[][] = new int[M][N];
        int size[] = new int[2501];
        
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (chk[r][c] != 0) continue;

                result[0]++;
                deque.offer(new Node(r, c));
                chk[r][c] = result[0];

                int temp = 0;
                Node cur;
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    size[result[0]]++;

                    for (int d = 0; d < 4; d++) {
                        int nr = cur.r + dr[d];
                        int nc = cur.c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= M || nc >= N) continue;

                        if ((arr[cur.r][cur.c] & (1 << d)) > 0) {
                            if (chk[cur.r][cur.c] != chk[nr][nc]) temp = Math.max(temp, size[chk[nr][nc]]);

                            continue;
                        }

                        if (chk[nr][nc] != 0) continue;

                        deque.offer(new Node(nr, nc));
                        chk[nr][nc] = result[0];
                    }
                }

                result[1] = Math.max(result[1], size[result[0]]);
                result[2] = Math.max(result[2], size[result[0]] + temp);
            }
        }

        System.out.println(result[0] + "\n" + result[1] + "\n" + result[2]);

        br.close();
    }
}