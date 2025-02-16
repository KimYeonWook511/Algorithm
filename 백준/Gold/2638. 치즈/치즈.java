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
        int cnt = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                if (st.nextToken().charAt(0) == '1') {
                    cnt++;
                    continue;
                }

                arr[r][c] = -1;
            }
        }

        Deque<int[]> cheeseDeque = new ArrayDeque<>();
        Deque<int[]> airDeque = new ArrayDeque<>();

        airDeque.offer(new int[]{0, 0});
        arr[0][0] = -2;

        int result = 0;
        int cur[];
        while (cnt > 0) {
            result++;

            while (!airDeque.isEmpty()) {
                cur = airDeque.poll();
    
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
    
                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= M) continue;
                    if (arr[nr][nc] == -2) continue;

                    if (arr[nr][nc] == -1) {
                        airDeque.offer(new int[]{nr, nc});
                        arr[nr][nc] = -2;
                        continue;
                    }

                    if (++arr[nr][nc] == 2) cheeseDeque.offer(new int[]{nr, nc});
                }
            }

            while (!cheeseDeque.isEmpty()) {
                cur = cheeseDeque.poll();
                
                arr[cur[0]][cur[1]] = -2;
                airDeque.offer(cur);
                cnt--;
            }
        }

        System.out.println(result);

        br.close();
    }
}