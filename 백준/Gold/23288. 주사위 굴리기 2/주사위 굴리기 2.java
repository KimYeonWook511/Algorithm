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
        int K = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        int parent[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                parent[r][c] = -1;
            }
        }

        int scores[] = new int[N * M];
        int scoreIndex = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (parent[r][c] == -1) {
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{r, c});
                    parent[r][c] = scoreIndex;

                    int cnt = 1;
                    while (!deque.isEmpty()) {
                        int cur[] = deque.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];

                            if (nr < 0 || nc < 0) continue;
                            if (nr >= N || nc >= M) continue;
                            if (parent[nr][nc] != -1) continue;

                            if (map[nr][nc] == map[r][c]) {
                                deque.offer(new int[]{nr, nc});
                                parent[nr][nc] = scoreIndex;
                                cnt++;
                            }
                        }
                    }

                    scores[scoreIndex] = cnt * map[r][c];
                    scoreIndex++;
                }
            }
        }

        int answer = 0;
        int dice[] = {2, 1, 5, 6, 4, 3}; // index3이 바닥
        int r = 0;
        int c = 0;
        int d = 1;
        for (int k = 0; k < K; k++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 벗어남
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                d = (d + 2) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            // 주사위 움직이기
            move(d, dice);

            // 방향 전환
            if (map[nr][nc] < dice[3]) {
                d = (d + 1) % 4;
            } else if (map[nr][nc] > dice[3]) {
                d = (d + 3) % 4;
            }

            // 점수 획득
            answer += scores[parent[nr][nc]];
            r = nr;
            c = nc;
        }

        System.out.println(answer);

        br.close();
    }

    static void move(int d, int dice[]) {
        if (d == 0) {
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = temp;
        } else if (d == 1) {
            int temp = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[3];
            dice[3] = temp;
        } else if (d == 2) {
            int temp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[0];
            dice[0] = dice[3];
            dice[3] = temp;
        } else if (d == 3) {
            int temp = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        }
    }
}