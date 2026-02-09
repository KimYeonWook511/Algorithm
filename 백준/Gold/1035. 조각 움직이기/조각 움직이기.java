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
    static final int MAX_SIZE = 5;
    static Node pieces[] = new Node[5];
    static int pieceCount = 0;

    static int start = 0;
    static boolean checked[][] = new boolean[MAX_SIZE][MAX_SIZE];

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pieces = new Node[5];
        for (int r = 0; r < MAX_SIZE; r++) {
            String line = br.readLine();
            for (int c = 0; c < MAX_SIZE; c++) {
                if (line.charAt(c) == '*') {
                    pieces[pieceCount++] = new Node(r, c);
                }
            }
        }

        for (int r = 0; r < MAX_SIZE; r++) {
            for (int c = 0; c < MAX_SIZE; c++) {
                start = r * MAX_SIZE + c;
                checked[r][c] = true;
                comb(start, 1);
                checked[r][c] = false;
            }
        }

        System.out.println(answer);

        br.close();
    }

    static void comb(int cur, int cnt) {
        if (cnt == pieceCount) {
            bfs();
            return;
        }

        for (int i = cur; i < MAX_SIZE * MAX_SIZE; i++) {
            int nr = i / MAX_SIZE;
            int nc = i % MAX_SIZE;
            checked[nr][nc] = true;
            comb(i + 1, cnt + 1);
            checked[nr][nc] = false;
        }
    }

    static void bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[MAX_SIZE][MAX_SIZE];
        deque.offer(new Node(start / MAX_SIZE, start % MAX_SIZE));
        visited[start / MAX_SIZE][start % MAX_SIZE] = true;

        List<Node> selected = new ArrayList<>();
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            selected.add(cur);

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= MAX_SIZE || nc >= MAX_SIZE) continue;
                if (visited[nr][nc]) continue;
                if (!checked[nr][nc]) continue;

                deque.offer(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        // 다 연결됨
        if (selected.size() == pieceCount) {
            cal(selected, 0, 0, 0);
        }
    }

    static void cal(List<Node> selected, int listIndex, int bit, int sum) {
        if (listIndex == selected.size()) {
            answer = Math.min(answer, sum);
            return;
        }

        Node cur = selected.get(listIndex);
        for (int i = 0; i < pieceCount; i++) {
            if ((bit & (1 << i)) != 0) continue;

            Node piece = pieces[i];
            int dist = Math.abs(cur.r - piece.r) + Math.abs(cur.c - piece.c);
            cal(selected, listIndex + 1, bit | (1 << i), sum + dist);
        }
    }
}