import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int arr[][];
    static int virusArr[][], virusIdx = 0;;
    static int blankCnt = 0;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        virusArr = new int[10][2];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());

                if (arr[r][c] == 0) {
                    arr[r][c] = Integer.MAX_VALUE;
                    blankCnt++;

                } else if (arr[r][c] == 1) {
                    arr[r][c] = -1;

                } else if (arr[r][c] == 2) {
                    virusArr[virusIdx][0] = r;
                    virusArr[virusIdx][1] = c;
                    virusIdx++;
                    arr[r][c] = -2;
                }
            }
        }

        combi(0, 0, 0);

        System.out.println(result == Integer.MAX_VALUE ? "-1" : result);

        br.close();
    }

    static void combi(int startIdx, int cnt, int selected) {
        if (cnt == M) {
            cal(selected);
            return;
        }

        for (int i = startIdx; i <= virusIdx - (M - cnt); i++) {
            combi(i + 1, cnt + 1, selected | (1 << i));
        }
    }

    static void cal(int selected) {
        int arr[][] = new int[N][N];
        copyArr(arr);

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < virusIdx; i++) {
            if ((selected & (1 << i)) == 0) continue;
            // 많아야 10번 돌기 때문에 굳이 넣은 바이러스 수는 추적 안 함

            deque.offer(new int[]{virusArr[i][0], virusArr[i][1], 1}); // 1이 시작
            arr[virusArr[i][0]][virusArr[i][1]] = 1;
        }

        int maxTime = 0;
        int spreadCnt = 0;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (arr[nr][nc] == -1) continue;
                if (arr[nr][nc] == -2) {
                    deque.offer(new int[]{nr, nc, cur[2] + 1});
                    arr[nr][nc] = cur[2] + 1;
                    continue;
                }

                if (arr[nr][nc] > cur[2] + 1) {
                    deque.offer(new int[]{nr, nc, cur[2] + 1});
                    arr[nr][nc] = cur[2] + 1;
                    spreadCnt++;
                    maxTime = Math.max(maxTime, cur[2]);
                }
            }
        }
        
        if (spreadCnt == blankCnt) result = Math.min(result, maxTime);
    }

    static void copyArr(int copy[][]) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                copy[r][c] = arr[r][c];
            }
        }
    }
}