import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        int cnt; // 쓰레기 지나는 수
        int sideCnt; // 쓰레기 주변을 지나는 수
        int w; // 거리

        Node (int r, int c, int cnt, int sideCnt, int w) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.sideCnt = sideCnt;
            this.w = w;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        int dist[][][] = new int[N][M][3];

        Node start = null;
        int end[] = new int[2];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);

                if (map[r][c] == 'S') {
                    start = new Node(r, c, 0, 0, 0);
                } else if (map[r][c] == 'F') {
                    end[0] = r;
                    end[1] = c;
                }

                for (int i = 0; i < 3; i++) {
                    dist[r][c][i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == '.') {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= N || nc >= M) continue;

                        if (map[nr][nc] == 'g') {
                            map[r][c] = 's';
                            break;
                        }
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.cnt != o2.cnt) return Integer.compare(o1.cnt, o2.cnt);
                if (o1.sideCnt != o2.sideCnt) return Integer.compare(o1.sideCnt, o2.sideCnt);
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[][] = new boolean[N][M];
        pq.offer(start);
        dist[start.r][start.c][0] = 0;
        dist[start.r][start.c][1] = 0;
        dist[start.r][start.c][2] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.r == end[0] && cur.c == end[1]) {
                System.out.println(cur.cnt + " " + cur.sideCnt);
                break;
            }

            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;

                // 움직이는 장소가 쓰레기 더미
                if (map[nr][nc] == 'g') {
                    if (dist[nr][nc][0] < cur.cnt + 1) continue;
                    if ((dist[nr][nc][0] == cur.cnt + 1) && (dist[nr][nc][1] < cur.sideCnt)) continue;
                    if ((dist[nr][nc][0] == cur.cnt + 1) && (dist[nr][nc][1] == cur.sideCnt) && (dist[nr][nc][2] <= cur.w + 1)) continue;

                    pq.offer(new Node(nr, nc, cur.cnt + 1, cur.sideCnt, cur.w + 1));
                    dist[nr][nc][0] = cur.cnt + 1;
                    dist[nr][nc][1] = cur.sideCnt;
                    dist[nr][nc][2] = cur.w + 1;
                    continue;
                }

                // 움직이는 장소가 쓰레기 더미 주변
                if (map[nr][nc] == 's') {
                    if (dist[nr][nc][0] < cur.cnt) continue;
                    if ((dist[nr][nc][0] == cur.cnt) && (dist[nr][nc][1] < cur.sideCnt + 1)) continue;
                    if ((dist[nr][nc][0] == cur.cnt) && (dist[nr][nc][1] == cur.sideCnt + 1) && (dist[nr][nc][2] <= cur.w + 1)) continue;

                    pq.offer(new Node(nr, nc, cur.cnt, cur.sideCnt + 1, cur.w + 1));
                    dist[nr][nc][0] = cur.cnt;
                    dist[nr][nc][1] = cur.sideCnt + 1;
                    dist[nr][nc][2] = cur.w + 1;
                    continue;
                }

                // 맨 땅 (or 꽃)
                if (dist[nr][nc][0] < cur.cnt) continue;
                if ((dist[nr][nc][0] == cur.cnt) && (dist[nr][nc][1] < cur.sideCnt)) continue;
                if ((dist[nr][nc][0] == cur.cnt) && (dist[nr][nc][1] == cur.sideCnt) && (dist[nr][nc][2] <= cur.w + 1)) continue;

                pq.offer(new Node(nr, nc, cur.cnt, cur.sideCnt, cur.w + 1));
                dist[nr][nc][0] = cur.cnt;
                dist[nr][nc][1] = cur.sideCnt;
                dist[nr][nc][2] = cur.w + 1;
            }
        }

        br.close();
    }
}