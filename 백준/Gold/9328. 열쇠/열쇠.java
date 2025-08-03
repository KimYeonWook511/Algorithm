import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cnt, r, c;

        Node (int cnt, int r, int c) {
            this.cnt = cnt;
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int result = 0;

            char arr[][] = new char[h][w];
            boolean key[] = new boolean[26];
            for (int r = 0; r < h; r++) {
                String line = br.readLine();

                for (int c = 0; c < w; c++) {
                    arr[r][c] = line.charAt(c);
                }
            }

            String line = br.readLine();
            int keyCnt = 0;
            if (line.charAt(0) != '0') {
                for (int i = 0; i < line.length(); i++) {
                    if (key[line.charAt(i) - 'a']) continue;
                    
                    key[line.charAt(i) - 'a'] = true;
                    keyCnt++;
                }
            }

            // 벽이 아닌 곳을 드나들 수 있음!!
            List<int[]> start = new ArrayList<>();
            for (int r = 0; r < h; r++) {
                if (arr[r][0] == '.' || arr[r][0] >= 'A' && arr[r][0] <= 'Z') {
                    start.add(new int[]{r, 0});

                } else if (arr[r][0] == '$') {
                    result++;
                    arr[r][0] = '.';
                    start.add(new int[]{r, 0});

                } else if (arr[r][0] >= 'a' && arr[r][0] <= 'z') {
                    if (!key[arr[r][0] - 'a']) {
                        key[arr[r][0] - 'a'] = true;
                        keyCnt++;
                    }

                    arr[r][0] = '.';
                    start.add(new int[]{r, 0});

                }

                if (arr[r][w - 1] == '.' || arr[r][w - 1] >= 'A' && arr[r][w - 1] <= 'Z') {
                    start.add(new int[]{r, w - 1});

                } else if (arr[r][w - 1] == '$') {
                    result++;
                    arr[r][w - 1] = '.';
                    start.add(new int[]{r, w - 1});

                } else if (arr[r][w - 1] >= 'a' && arr[r][w - 1] <= 'z') {
                    if (!key[arr[r][w - 1] - 'a']) {
                        key[arr[r][w - 1] - 'a'] = true;
                        keyCnt++;
                    }

                    arr[r][w - 1] = '.';
                    start.add(new int[]{r, w - 1});
                }
            }
            for (int c = 0; c < w; c++) {
                if (arr[0][c] == '.' || arr[0][c] >= 'A' && arr[0][c] <= 'Z') {
                    start.add(new int[]{0, c});

                } else if (arr[0][c] == '$') {
                    result++;
                    arr[0][c] = '.';
                    start.add(new int[]{0, c});

                } else if (arr[0][c] >= 'a' && arr[0][c] <= 'z') {
                    if (!key[arr[0][c] - 'a']) {
                        key[arr[0][c] - 'a'] = true;
                        keyCnt++;
                    }

                    arr[0][c] = '.';
                    start.add(new int[]{0, c});
                }

                if (arr[h - 1][c] == '.' || arr[h - 1][c] >= 'A' && arr[h - 1][c] <= 'Z') {
                    start.add(new int[]{h - 1, c});

                } else if (arr[h - 1][c] == '$') {
                    result++;
                    arr[h - 1][c] = '.';
                    start.add(new int[]{0, c});

                } else if (arr[h - 1][c] >= 'a' && arr[h - 1][c] <= 'z') {
                    if (!key[arr[h - 1][c] - 'a']) {
                        key[arr[h - 1][c] - 'a'] = true;
                        keyCnt++;
                    }
                    
                    arr[h - 1][c] = '.';
                    start.add(new int[]{h - 1, c});
                }
            }

            Deque<Node> deque = new ArrayDeque<>();
            boolean visited[][][] = new boolean[27][h][w];
            for (int k = 0; k < start.size(); k++) {
                int cur[] = start.get(k);

                if (arr[cur[0]][cur[1]] == '.' || key[arr[cur[0]][cur[1]] - 'A']) {
                    deque.offer(new Node(keyCnt, cur[0], cur[1]));
                    visited[keyCnt][cur[0]][cur[1]] = true;
                }
            }

            while (!deque.isEmpty()) {
                Node cur = deque.poll();

                if (cur.cnt < keyCnt) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= h || nc >= w) continue;
                    if (visited[cur.cnt][nr][nc]) continue;
                    if (arr[nr][nc] == '*') continue;

                    if (arr[nr][nc] == '.') {
                        deque.offer(new Node(cur.cnt, nr, nc));
                        visited[cur.cnt][nr][nc] = true;
                        continue;
                    } 
                    
                    if (arr[nr][nc] == '$') {
                        result++;
                        deque.offer(new Node(cur.cnt, nr, nc));
                        visited[cur.cnt][nr][nc] = true;
                        arr[nr][nc] = '.';
                        continue;
                    }
                    
                    if (arr[nr][nc] >= 'A' && arr[nr][nc] <= 'Z') {
                        if (!key[arr[nr][nc] - 'A']) continue; // 열쇠 없음

                        deque.offer(new Node(cur.cnt, nr, nc));
                        visited[cur.cnt][nr][nc] = true;
                        arr[nr][nc] = '.';
                        continue;
                    }
                    
                    if (arr[nr][nc] >= 'a' && arr[nr][nc] <= 'z') {
                        if (key[arr[nr][nc] - 'a']) {
                            // 이미 있는 열쇠
                            deque.offer(new Node(cur.cnt, nr, nc));
                            visited[cur.cnt][nr][nc] = true;

                        } else {
                            // 새롭게 열쇠 얻음
                            key[arr[nr][nc] - 'a'] = true;
                            keyCnt++;
                            for (int k = 0; k < start.size(); k++) {
                                int curStart[] = start.get(k);
                                
                                if (arr[curStart[0]][curStart[1]] == '.' || key[arr[curStart[0]][curStart[1]] - 'A']) {
                                    deque.offer(new Node(keyCnt, curStart[0], curStart[1]));
                                    visited[keyCnt][curStart[0]][curStart[1]] = true;
                                }
                            }
                        }

                        arr[nr][nc] = '.';
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}