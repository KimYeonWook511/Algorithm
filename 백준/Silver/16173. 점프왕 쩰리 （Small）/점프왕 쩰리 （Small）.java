import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {0, 1};
    static int dc[] = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        boolean chk[][] = new boolean[N][N];

        deque.offer(new int[]{0 ,0});
        chk[0][0] = true;

        boolean flag = false;
        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur[0] == N - 1 && cur[1] == N - 1) {
                flag = true;
                break;
            }

            int nr, nc;
            for (int d = 0; d < 2; d++) {
                nr = cur[0] + arr[cur[0]][cur[1]] * dr[d];
                nc = cur[1] + arr[cur[0]][cur[1]] * dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (chk[nr][nc]) continue;
                
                deque.offer(new int[]{nr, nc});
                chk[nr][nc] = true;
            }
        }

        System.out.println(flag ? "HaruHaru" : "Hing");

        br.close();
    }
}