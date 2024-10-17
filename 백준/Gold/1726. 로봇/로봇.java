import java.io.*;
import java.util.*;

public class Main {
    static class Robot {
        int r, c, d, w;
        
        Robot (int r, int c, int d, int w) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.w = w;
        }
    }
    
    static int dr[] = {0, 0, 0, 1, -1};
    static int dc[] = {0, 1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        Deque<Robot> deque = new ArrayDeque<>();
        boolean arr[][] = new boolean[M][N];
        boolean chk[][][] = new boolean[5][M][N];
        
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < N; c++) {
                arr[r][c] = st.nextToken().charAt(0) == '0' ? true : false;
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int start[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
        
        st = new StringTokenizer(br.readLine());
        int end[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};

        deque.offer(new Robot(start[0], start[1], start[2], 0));
        chk[start[2]][start[0]][start[1]] = true;
        
        Robot cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            
            if (cur.r == end[0] && cur.c == end[1] && cur.d == end[2]) {
                System.out.println(cur.w);
                break;
            }

            int nr, nc;
            for (int k = 1; k <= 3; k++) {
                nr = cur.r + dr[cur.d] * k;
                nc = cur.c + dc[cur.d] * k;
                
                // 직진 불가능
                if (nr < 0 || nc < 0) break;
                if (nr >= M || nc >= N) break;
                if (!arr[nr][nc]) break;

                if (chk[cur.d][nr][nc]) continue;
                
                deque.offer(new Robot(nr, nc, cur.d, cur.w + 1));
                chk[cur.d][nr][nc] = true;
            }
            
            if (cur.d >= 3) {
                if (!chk[1][cur.r][cur.c]) {
                    deque.offer(new Robot(cur.r, cur.c, 1, cur.w + 1));
                    chk[1][cur.r][cur.c] = true;
                }

                if (!chk[2][cur.r][cur.c]) {
                    deque.offer(new Robot(cur.r, cur.c, 2, cur.w + 1));
                    chk[2][cur.r][cur.c] = true;
                }

            } else {
                if (!chk[3][cur.r][cur.c]) {
                    deque.offer(new Robot(cur.r, cur.c, 3, cur.w + 1));
                    chk[3][cur.r][cur.c] = true;
                }

                if (!chk[4][cur.r][cur.c]) {
                    deque.offer(new Robot(cur.r, cur.c, 4, cur.w + 1));
                    chk[4][cur.r][cur.c] = true;
                }
            }
        }
        
        br.close();
    }
}