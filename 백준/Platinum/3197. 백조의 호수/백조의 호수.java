import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static boolean arr[][];
    static int parent[][], idx = 1;
    static Map<Integer, int[]> map = new HashMap<>();
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new boolean[R][C];
        parent = new int[R][C];

        Deque<int[]> tempDeque = new ArrayDeque<>();
        String line = "";

        for (int r = 0; r < R; r++) {
            line = br.readLine();

            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);

                if (ch == 'X') continue;

                arr[r][c] = true;

                if (ch == 'L') {
                    parent[r][c] = idx;
                    tempDeque.offer(new int[]{r, c});
                    map.put(idx++, new int[]{r, c});
                }
            }
        }

        // 백조 최초 bfs
        initBfs(tempDeque);

        // 최초 물 bfs
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] && parent[r][c] == 0) {
                    parent[r][c] = idx;
                    tempDeque.offer(new int[]{r, c});
                    map.put(idx++, new int[]{r, c});

                    initBfs(tempDeque);
                }
            }
        }

        int time = 0;

        while (true) {
            if (find(map.get(1)) == find(map.get(2))) break;

            time++;

            bfs();
        }

        System.out.println(time);

        br.close();
    }

    static int find(int rc[]) {
        // 백조있는 물 -> 1,2 / 물 -> 3...
        int p[] = map.get(parent[rc[0]][rc[1]]);
        
        if (p[0] == rc[0] && p[1] == rc[1]) return parent[rc[0]][rc[1]];
        
        return parent[rc[0]][rc[1]] = find(p);
    }

    static void union(int x[], int y[]) {
        int x1 = find(x);
        int y1 = find(y);

        if (x1 < y1) {
            int p[] = map.get(y1);
            parent[p[0]][p[1]] = x1;

        } else {
            int p[] = map.get(x1);
            parent[p[0]][p[1]] = y1;
        }
    }

    static void initBfs(Deque<int[]> tempDeque) {
        while (!tempDeque.isEmpty()) {
            int cur[] = tempDeque.poll();

            boolean isEdge = false;

            for (int i = 0; i < 4; i++) {
                int n[] = {cur[0] + dr[i], cur[1] + dc[i]};

                if (n[0] < 0 || n[1] < 0) continue;
                if (n[0] >= R || n[1] >= C) continue;
                if (parent[n[0]][n[1]] == parent[cur[0]][cur[1]]) continue;
                if (!arr[n[0]][n[1]]) {
                    isEdge = true;
                    continue;
                }

                if (parent[n[0]][n[1]] > 0) {
                    // 백조끼리 이미 만날 수 있는 경우
                    union(map.get(parent[cur[0]][cur[1]]), map.get(parent[n[0]][n[1]]));
                    continue;
                }

                parent[n[0]][n[1]] = parent[cur[0]][cur[1]];
                tempDeque.offer(n);
            }

            if (isEdge) deque.offer(cur);
        }
    }

    static void bfs() {
        int size = deque.size();

        for (int k = 0; k < size; k++) {
            int cur[] = deque.poll();

            for (int i = 0; i < 4; i++) {
                int n[] = {cur[0] + dr[i], cur[1] + dc[i]};

                if (n[0] < 0 || n[1] < 0) continue;
                if (n[0] >= R || n[1] >= C) continue;
                if (parent[n[0]][n[1]] != 0) continue;
                
                arr[n[0]][n[1]] = true;
                parent[n[0]][n[1]] = parent[cur[0]][cur[1]];
                deque.offer(n);

                for (int p = 0; p < 4; p++) {
                    int n2[] = {n[0] + dr[p], n[1] + dc[p]};

                    if (n2[0] < 0 || n2[1] < 0) continue;
                    if (n2[0] >= R || n2[1] >= C) continue;
                    if (parent[n2[0]][n2[1]] == 0) continue;

                    union(n, n2);
                }
            }
        }
    }
}