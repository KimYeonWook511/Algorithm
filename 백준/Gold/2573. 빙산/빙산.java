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

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        int result = 0;
        while (true) {
            boolean chk[][] = new boolean[N][M];
            boolean flag = false;
            boolean end = false;

            for (int r = 1; r < N - 1; r++) {
                for (int c = 1; c < M - 1; c++) {
                    if (arr[r][c] <= 0 || chk[r][c]) continue;

                    if (flag) {
                        r = N;
                        end = true;
                        break;
                    }

                    flag = true;
                    deque.offer(new int[]{r, c});
                    chk[r][c] = true;

                    int[] cur;
                    while (!deque.isEmpty()) {
                        cur = deque.poll();

                        int nr, nc;
                        for (int d = 0; d < 4; d++) {
                            nr = cur[0] + dr[d];
                            nc = cur[1] + dc[d];

                            if (chk[nr][nc]) continue;
                            if (arr[nr][nc] > 0) {
                                deque.offer(new int[]{nr, nc});
                                chk[nr][nc] = true;

                                continue;
                            }

                            arr[cur[0]][cur[1]]--;
                        }
                    }
                }
            }

            if (end) break;

            if (!flag) {
                result = 0;
                break;
            }

            result++;
        }

        System.out.println(result);

        br.close();
    }
}