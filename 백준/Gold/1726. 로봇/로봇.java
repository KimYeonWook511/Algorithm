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
        
        PriorityQueue<Robot> pq = new PriorityQueue<>(new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean arr[][] = new boolean[M][N];
        int chk[][][] = new int[5][M][N];
        
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            
            for (int c = 0; c < N; c++) {
                arr[r][c] = st.nextToken().charAt(0) == '0' ? true : false;
                
                for (int i = 1; i <= 4; i++) {
                    chk[i][r][c] = Integer.MAX_VALUE;
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int start[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
        
        st = new StringTokenizer(br.readLine());
        int end[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};

        pq.offer(new Robot(start[0], start[1], start[2], 0));
        chk[start[2]][start[0]][start[1]] = 0;
        
        Robot cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            
            if (cur.w > chk[cur.d][cur.r][cur.c]) continue;

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

                if (chk[cur.d][nr][nc] <= cur.w + 1) continue;
                
                pq.offer(new Robot(nr, nc, cur.d, cur.w + 1));
                chk[cur.d][nr][nc] = cur.w + 1;
            }
            
            if (cur.d >= 3) {
                if (chk[1][cur.r][cur.c] > cur.w + 1) {
                    pq.offer(new Robot(cur.r, cur.c, 1, cur.w + 1));
                    chk[1][cur.r][cur.c] = cur.w + 1;
                }

                if (chk[2][cur.r][cur.c] > cur.w + 1) {
                    pq.offer(new Robot(cur.r, cur.c, 2, cur.w + 1));
                    chk[2][cur.r][cur.c] = cur.w + 1;
                }

            } else {
                if (chk[3][cur.r][cur.c] > cur.w + 1) {
                    pq.offer(new Robot(cur.r, cur.c, 3, cur.w + 1));
                    chk[3][cur.r][cur.c] = cur.w + 1;
                }

                if (chk[4][cur.r][cur.c] > cur.w + 1) {
                    pq.offer(new Robot(cur.r, cur.c, 4, cur.w + 1));
                    chk[4][cur.r][cur.c] = cur.w + 1;
                }
            }
        }
        
        br.close();
    }
}