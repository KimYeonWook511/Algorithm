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
    static int N;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static char map[][];
    static Node teachers[], blanks[];
    static int teacherCount = 0, blankCount = 0;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teachers = new Node[N * N];
        blanks = new Node[N * N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().charAt(0);

                if (map[r][c] == 'T') teachers[teacherCount++] = new Node(r, c);
                else if (map[r][c] == 'X') blanks[blankCount++] = new Node(r, c);
            }
        }

        func(0, 0);

        System.out.println(flag ? "YES" : "NO");

        br.close();
    }

    static void func(int cnt, int startIndex) {
        if (flag) return;
        if (cnt == 3) {
            if (chk()) flag = true;

            return;
        }

        for (int i = startIndex; i < blankCount; i++) {
            Node cur = blanks[i];
            map[cur.r][cur.c] = 'O';
            func(cnt + 1, i + 1);
            map[cur.r][cur.c] = 'X';

            if (flag) return;
        }
    }

    static boolean chk() {
        for (int i = 0; i < teacherCount; i++) {
            Node cur = teachers[i];

            for (int d = 0; d < 4; d++) {
                int nr = cur.r;
                int nc = cur.c;

                while (true) {
                    nr += dr[d];
                    nc += dc[d];

                    if (nr < 0 || nc < 0) break;
                    if (nr >= N || nc >= N) break;
                    if (map[nr][nc] == 'O') break;
                    if (map[nr][nc] == 'T') break;

                    if (map[nr][nc] == 'S') return false;
                }
            }
        }

        return true;
    }
}