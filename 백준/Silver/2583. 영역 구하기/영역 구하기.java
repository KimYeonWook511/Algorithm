import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[M][N];
        for (int run = 0; run < K; run++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (; y1 < y2; y1++) {
                for (int c = x1; c < x2; c++) {
                    arr[y1][c] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int size = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c]) continue;

                deque.offer(new int[]{r, c});
                arr[r][c] = true;
                int cnt = 0;

                while (!deque.isEmpty()) {
                    int cur[] = deque.poll();

                    cnt++;

                    int nr, nc;

                    for (int i = 0; i < 4; i++) {
                        nr = cur[0] + dr[i];
                        nc = cur[1] + dc[i];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= M || nc >= N) continue;
                        if (arr[nr][nc]) continue;

                        arr[nr][nc] = true;
                        deque.offer(new int[]{nr ,nc});
                    }
                }

                list.add(cnt);
                size++;
            }
        }

        sb.append(size).append("\n");

        Collections.sort(list);
        for (int cnt : list) {
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}