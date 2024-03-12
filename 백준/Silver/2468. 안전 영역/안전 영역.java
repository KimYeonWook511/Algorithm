import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][N];
        int maxH = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());

                maxH = Math.max(maxH, arr[r][c]);
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        int h = 0;
        int max = 0;

        while (h < maxH) {
            boolean chk[][] = new boolean[N][N];
            int cnt = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (arr[r][c] <= h || chk[r][c]) continue;

                    chk[r][c] = true;
                    deque.offer(new int[]{r, c});

                    while (!deque.isEmpty()) {
                        int cur[] = deque.poll();

                        int nr, nc;

                        for (int i = 0; i < 4; i++) {
                            nr = cur[0] + dr[i];
                            nc = cur[1] + dc[i];
                            
                            if (nr < 0 || nc < 0) continue;
                            if (nr >= N || nc >= N) continue;
                            if (chk[nr][nc]) continue;

                            chk[nr][nc] = true;

                            if (arr[nr][nc] > h) deque.offer(new int[]{nr, nc});
                        }
                    }

                    cnt++;
                }
            }

            if (cnt == 0) break;

            max = Math.max(max, cnt);
            h++;
        }

        System.out.println(max);

        br.close();
    }
}