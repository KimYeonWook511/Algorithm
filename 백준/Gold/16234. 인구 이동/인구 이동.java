import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int temp[][] = new int[N * N][2];
        while (true) {
            boolean flag = true;
            boolean chk[][] = new boolean[N][N];
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (chk[r][c]) continue;

                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{r, c});
                    chk[r][c] = true;
                    int idx = 0;
                    int sum = 0;

                    int cur[];
                    while (!deque.isEmpty()) {
                        cur = deque.poll();

                        temp[idx++] = cur;
                        sum += arr[cur[0]][cur[1]];

                        int nr, nc;
                        for (int d = 0; d < 4; d++) {
                            nr = cur[0] + dr[d];
                            nc = cur[1] + dc[d];

                            if (nr < 0 || nc < 0) continue;
                            if (nr >= N || nc >= N) continue;
                            if (chk[nr][nc]) continue;
                            if (Math.abs(arr[nr][nc] - arr[cur[0]][cur[1]]) < L) continue;
                            if (Math.abs(arr[nr][nc] - arr[cur[0]][cur[1]]) > R) continue;

                            deque.offer(new int[]{nr ,nc});
                            chk[nr][nc] = true;
                            flag = false;
                        }
                    }

                    int avg = sum / idx;
                    for (int i = 0; i < idx; i++) {
                        arr[temp[i][0]][temp[i][1]] = avg;
                    }
                }
            }

            if (flag) break;

            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}