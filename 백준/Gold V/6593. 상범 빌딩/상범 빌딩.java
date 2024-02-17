import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int L, R, C, start[], end[], d[][] = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}};
    static boolean arr[][][], chk[][][];
    static String line;
    static Deque<int[]> deque;

    public static void main(String[] args) throws Exception {
        TC : while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0) break; // L == 0 && R == 0 && C == 0

            start = new int[3];
            end = new int[3];
            arr = new boolean[L + 2][R + 2][C + 2];
            chk = new boolean[L + 2][R + 2][C + 2];

            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    line = br.readLine();

                    for (int c = 1; c <= C; c++) {
                        switch (line.charAt(c - 1)) {
                            case '.': 
                                arr[l][r][c] = true;
                                break;

                            case '#':
                                break;

                            case 'S':
                                start[0] = l;
                                start[1] = r;
                                start[2] = c;
                                break;
                            case 'E':
                                end[0] = l;
                                end[1] = r;
                                end[2] = c;
                                break;
                        }
                    }
                }

                br.readLine(); // 빈 줄 (다음 층)
            }

            // bfs
            deque = new ArrayDeque<>();
            int time = 0;
            int cur[] = new int[3];

            deque.offerLast(cur);
            deque.offerLast(start);

            while (!deque.isEmpty()) {
                cur = deque.pollFirst();

                if (cur[0] == 0 && cur[1] == 0 && cur[2] == 0) {
                    if (deque.isEmpty()) {
                        sb.append("Trapped!\n");

                        break;
                    }

                    time++;
                    deque.offerLast(cur);
                    cur = deque.pollFirst();
                }

                for (int i = 0; i < 6; i++) {
                    int next[] = new int[3];
                    next[0] = cur[0] + d[i][0];
                    next[1] = cur[1] + d[i][1];
                    next[2] = cur[2] + d[i][2];

                    if (chk[next[0]][next[1]][next[2]]) continue;
                    
                    if (next[0] == end[0] && next[1] == end[1] && next[2] == end[2]) {
                        sb.append("Escaped in ").append(time).append(" minute(s).\n");
                        
                        continue TC;
                    }
                    
                    chk[next[0]][next[1]][next[2]] = true;
                    if (arr[next[0]][next[1]][next[2]]) deque.offerLast(next);
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}