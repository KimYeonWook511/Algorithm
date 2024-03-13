import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, -2, -2, -1};
    static int dc[] = {-2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int l = Integer.parseInt(br.readLine());

            int arr[][] = new int[l][l];

            Deque<int[]> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            deque.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});

            st = new StringTokenizer(br.readLine());
            int end[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            boolean chk[][] = new boolean[l][l];

            while (!deque.isEmpty()) {
                int cur[] = deque.poll();

                if (cur[0] == end[0] && cur[1] == end[1]) {
                    sb.append(cur[2]).append("\n");
                    break;
                }

                int nr1, nr2, nc;

                for (int i = 0; i < 4; i++) {
                    nr1 = cur[0] + dr[i];
                    nr2 = cur[0] - dr[i];
                    nc = cur[1] + dc[i];

                    if (nc < 0 || nc >= l) continue;

                    if (nr1 >= 0 && nr1 < l && !chk[nr1][nc]) {
                        chk[nr1][nc] = true;
                        deque.offer(new int[]{nr1, nc, cur[2] + 1});
                    }

                    if (nr2 >= 0 && nr2 < l && !chk[nr2][nc]) {
                        chk[nr2][nc] = true;
                        deque.offer(new int[]{nr2, nc, cur[2] + 1});
                    }
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}