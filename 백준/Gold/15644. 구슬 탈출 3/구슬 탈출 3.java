import java.io.*;
import java.util.*;

public class Main {
    static class Bead {
        int r, c;

        Bead (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class Node {
        Bead red;
        Bead blue;
        int cnt;

        Node (Bead red, Bead blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static char dChar[] = {'U', 'R', 'D', 'L'};

    static int N, M;
    static boolean map[][];
    static Bead end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        Bead startRed = new Bead(0, 0);
        Bead startBlue = new Bead(0, 0);
        end = new Bead(0, 0);
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                char ch = line.charAt(c);

                if (ch == '#') continue;

                map[r][c] = true;
                if (ch == 'R') {
                    startRed.r = r;
                    startRed.c = c;
                } else if (ch == 'B') {
                    startBlue.r = r;
                    startBlue.c = c;
                } else if (ch == 'O') {
                    end.r = r;
                    end.c = c;
                }
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        Node visited[][][][] = new Node[N][M][N][M];
        char visitedDir[][][][] = new char[N][M][N][M];
        Node start = new Node(startRed, startBlue, 0);
        deque.offer(start);
        visited[startRed.r][startRed.c][startBlue.r][startBlue.c] = start;
        visitedDir[startRed.r][startRed.c][startBlue.r][startBlue.c] = 'S'; // 시작 표시

        Node answer = null;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            Bead curRed = cur.red;
            Bead curBlue = cur.blue;

            if (curRed.r == end.r && curRed.c == end.c) {
                answer = cur;
                break;
            }

            if (cur.cnt == 10) continue;

            for (int d = 0; d < 4; d++) {
                Bead nextRed = move(curRed, d);
                Bead nextBlue = move(curBlue, d);

                // blue가 구멍에 빠지는 지 확인
                if (nextBlue.r == end.r && nextBlue.c == end.c) continue;

                // 겹치면 좌표 조정
                if (isOverlap(nextRed, nextBlue)) {
                    fixOverlap(curRed, curBlue, nextRed, nextBlue, d);
                }

                if (visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c] == null) {
                    deque.offer(new Node(nextRed, nextBlue, cur.cnt + 1));
                    visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c] = cur;
                    visitedDir[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c] = dChar[d];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (answer == null) {
            sb.append("-1");
        } else {
            sb.append(answer.cnt).append("\n");

            // 역추적 실행
            Bead red = answer.red;
            Bead blue = answer.blue;
            StringBuilder tracking = new StringBuilder();
            while (visitedDir[red.r][red.c][blue.r][blue.c] != 'S') {
                tracking.append(visitedDir[red.r][red.c][blue.r][blue.c]);
                Node pre = visited[red.r][red.c][blue.r][blue.c];
                red = pre.red;
                blue = pre.blue;
            }
            sb.append(tracking.reverse());
        }

        System.out.println(sb);

        br.close();
    }

    static Bead move(Bead cur, int d) {
        Bead ret = new Bead(cur.r, cur.c);
        while (true) {
            int nr = ret.r + dr[d];
            int nc = ret.c + dc[d];
            if (!map[nr][nc]) break;

            ret.r = nr;
            ret.c = nc;
            if (nr == end.r && nc == end.c) break;
        }
        return ret;
    }

    static boolean isOverlap(Bead red, Bead blue) {
        return red.r == blue.r && red.c == blue.c;
    }

    static void fixOverlap(Bead curRed, Bead curBlue, Bead nextRed, Bead nextBlue, int d) {
        if (d == 0) {
            if (curRed.r > curBlue.r) {
                nextRed.r += 1;
            } else {
                nextBlue.r += 1;
            }
        } else if (d == 1) {
            if (curRed.c < curBlue.c) {
                nextRed.c -= 1;
            } else {
                nextBlue.c -= 1;
            }
        } else if (d == 2) {
            if (curRed.r < curBlue.r) {
                nextRed.r -= 1;
            } else {
                nextBlue.r -= 1;
            }
        } else if (d == 3) {
            if (curRed.c > curBlue.c) {
                nextRed.c += 1;
            } else {
                nextBlue.c += 1;
            }
        }
    }
}