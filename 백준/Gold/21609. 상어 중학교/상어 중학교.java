import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int N;
    static int map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st.nextToken(); // M

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int state = 0;
        int answer = 0;
        while (true) {
            Node node = new Node(-1, -1);

            if (state == 0) {
                search0(node);
            } else if (state == 1) {
                search1(node);
            } else if (state == 2) {
                search2(node);
            } else if (state == 3) {
                search3(node);
            }

            if (node.r == -1) {
                // 더이상 블록 그룹 없음
                break;
            }

            // 블록 없애기
            int B = broken(node, map[node.r][node.c]);
            answer += (B * B);

            // drop
            if (state == 0) {
                drop0();
            } else if (state == 1) {
                drop1();
            } else if (state == 2) {
                drop2();
            } else if (state == 3) {
                drop3();
            }

            // spin
            state = (state + 1) % 4;

            // drop
            if (state == 0) {
                drop0();
            } else if (state == 1) {
                drop1();
            } else if (state == 2) {
                drop2();
            } else if (state == 3) {
                drop3();
            }
        }

        System.out.println(answer);

        br.close();
    }

    static void search0(Node node) {
        boolean visited[][] = new boolean[N][N];
        int maxCount = 2;
        int maxRainbowCount = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] <= 0) continue;
                if (visited[r][c]) continue;

                int cnt[] = bfs(r, c, visited);

                if (maxCount < cnt[0]) {
                    maxCount = cnt[0];
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                } else if (maxCount == cnt[0] && maxRainbowCount <= cnt[1]) {
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                }
            }
        }
    }

    static void search1(Node node) {
        boolean visited[][] = new boolean[N][N];
        int maxCount = 2;
        int maxRainbowCount = 0;
        for (int c = N - 1; c >= 0; c--) {
            for (int r = 0; r < N; r++) {
                if (map[r][c] <= 0) continue;
                if (visited[r][c]) continue;

                int cnt[] = bfs(r, c, visited);

                if (maxCount < cnt[0]) {
                    maxCount = cnt[0];
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                } else if (maxCount == cnt[0] && maxRainbowCount <= cnt[1]) {
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                }
            }
        }
    }

    static void search2(Node node) {
        boolean visited[][] = new boolean[N][N];
        int maxCount = 2;
        int maxRainbowCount = 0;
        for (int r = N - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {
                if (map[r][c] <= 0) continue;
                if (visited[r][c]) continue;

                int cnt[] = bfs(r, c, visited);

                if (maxCount < cnt[0]) {
                    maxCount = cnt[0];
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                } else if (maxCount == cnt[0] && maxRainbowCount <= cnt[1]) {
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                }
            }
        }
    }

    static void search3(Node node) {
        boolean visited[][] = new boolean[N][N];
        int maxCount = 2;
        int maxRainbowCount = 0;
        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r >= 0; r--) {
                if (map[r][c] <= 0) continue;
                if (visited[r][c]) continue;

                int cnt[] = bfs(r, c, visited);

                if (maxCount < cnt[0]) {
                    maxCount = cnt[0];
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                } else if (maxCount == cnt[0] && maxRainbowCount <= cnt[1]) {
                    maxRainbowCount = cnt[1];
                    node.r = r;
                    node.c = c;
                }
            }
        }
    }

    static int[] bfs(int r, int c, boolean visited[][]) {
        // 무지개, 그리고 같은 블럭 색 담기
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(r, c));
        visited[r][c] = true;

        int normalCount = 1;
        int rainbowCount = 0;
        Deque<Node> rainbowDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    Node next = new Node(nr, nc);
                    deque.offer(next);
                    visited[nr][nc] = true;
                    rainbowDeque.offer(next);
                    rainbowCount++;
                } else if (map[nr][nc] == map[r][c]) {
                    deque.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                    normalCount++;
                }
            }
        }

        // 무지개 블록 방문 처리 해제
        while (!rainbowDeque.isEmpty()) {
            Node cur = rainbowDeque.poll();
            visited[cur.r][cur.c] = false;
        }

        return new int[]{normalCount + rainbowCount, rainbowCount};
    }

    static int broken(Node node, int color) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(node);
        map[node.r][node.c] = -2;

        int cnt = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;

                if (map[nr][nc] == 0 || map[nr][nc] == color) {
                    deque.offer(new Node(nr, nc));
                    map[nr][nc] = -2;
                }
            }
        }

        return cnt;
    }

    static void drop0() {
        for (int c = 0; c < N; c++) {
            for (int r = N - 2; r >= 0; r--) {
                if (map[r][c] < 0) continue;

                int row = r;
                while (row < N - 1) {
                    if (map[row + 1][c] != -2) break;

                    map[row + 1][c] = map[row][c];
                    map[row][c] = -2;
                    row++;
                }
            }
        }
    }

    static void drop1() {
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if (map[r][c] < 0) continue;

                int col = c;
                while (col > 0) {
                    if (map[r][col - 1] != -2) break;

                    map[r][col - 1] = map[r][col];
                    map[r][col] = -2;
                    col--;
                }
            }
        }
    }

    static void drop2() {
        for (int c = 0; c < N; c++) {
            for (int r = 1; r < N; r++) {
                if (map[r][c] < 0) continue;

                int row = r;
                while (row > 0) {
                    if (map[row - 1][c] != -2) break;

                    map[row - 1][c] = map[row][c];
                    map[row][c] = -2;
                    row--;
                }
            }
        }
    }

    static void drop3() {
        for (int r = 0; r < N; r++) {
            for (int c = N - 2; c >= 0; c--) {
                if (map[r][c] < 0) continue;

                int col = c;
                while (col < N - 1) {
                    if (map[r][col + 1] != -2) break;

                    map[r][col + 1] = map[r][col];
                    map[r][col] = -2;
                    col++;
                }
            }
        }
    }
}