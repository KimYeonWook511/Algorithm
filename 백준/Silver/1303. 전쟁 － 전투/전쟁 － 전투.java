import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[M][N];
        boolean chk[][] = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            String line = br.readLine();

            for (int c = 0; c < N; c++) {
                arr[r][c] = line.charAt(c) == 'W' ? true : false;
            }
        }
    
        Deque<int[]> deque = new ArrayDeque<>();
        int W = 0;
        int B = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (chk[r][c]) continue;

                chk[r][c] = true;
                deque.offer(new int[]{r, c});

                int cnt = 1;
                int cur[];
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    int nr, nc;
                    for (int d = 0; d < 4; d++) {
                        nr = cur[0] + dr[d];
                        nc = cur[1] + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= M || nc >= N) continue;
                        if (chk[nr][nc]) continue;
                        if (arr[nr][nc] != arr[r][c]) continue;

                        chk[nr][nc] = true;
                        deque.offer(new int[]{nr, nc});
                        cnt++;
                    }
                }

                if (arr[r][c]) W += cnt * cnt;
                else B += cnt * cnt;
            }
        }

        System.out.println(W + " " + B);

        br.close();
    }
}