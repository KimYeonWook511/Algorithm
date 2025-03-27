import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1 ,0 ,1 ,0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                if (line.charAt(c) == '1') arr[r][c] = -1;
            }
        }

        Map<Integer, Integer> cntMap = new HashMap<>();
        int idx = 1;

        Deque<int[]> deque = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] != 0) continue;

                deque.offer(new int[]{r, c});
                arr[r][c] = idx;
                cntMap.put(idx, 1);

                while (!deque.isEmpty()) {
                    int cur[] = deque.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= N || nc >= M) continue;
                        if (arr[nr][nc] != 0) continue;

                        deque.offer(new int[]{nr, nc});
                        arr[nr][nc] = idx;
                        cntMap.put(idx, cntMap.get(idx) + 1);
                    }
                }

                idx++;
            }
        }

        boolean chk[] = new boolean[cntMap.size() + 1];
        int tempIdx[] = new int[4];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int cnt = 0;
                idx = 0;

                if (arr[r][c] == -1) {
                    cnt++;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= N || nc >= M) continue;
                        if (arr[nr][nc] == -1) continue;
                        if (chk[arr[nr][nc]]) continue;

                        chk[arr[nr][nc]] = true;
                        tempIdx[idx++] = arr[nr][nc];
                        cnt += cntMap.get(arr[nr][nc]);
                    }

                    for (int i = 0; i < idx; i++) {
                        chk[tempIdx[i]] = false;
                    }
                }

                sb.append(cnt % 10);
            }

            sb.append("\n");
        }
        
        System.out.println(sb);

        br.close();
    }
}