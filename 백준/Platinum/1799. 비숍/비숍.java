import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static boolean crossVisited[][]; // 대각선 방문 처리
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Node> black = new ArrayList<>();
        List<Node> white = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if (st.nextToken().equals("0")) continue;

                if ((r + c) % 2 == 0) black.add(new Node(r, c));
                else white.add(new Node(r, c));
            }
        }

        int answer = 0;

        max = 0;
        crossVisited = new boolean[2][N * 2];
        func(0, 0, black);
        answer += max;

        max = 0;
        crossVisited = new boolean[2][N * 2];
        func(0, 0, white);
        answer += max;

        System.out.println(answer);

        br.close();
    }

    static void func(int idx, int cnt, List<Node> list) {
        if (cnt + (list.size() - idx) <= max) return;

        if (idx == list.size()) {
            max = Math.max(max, cnt);
            return;
        }

        Node cur = list.get(idx);
        int r = cur.r;
        int c = cur.c;

        int ld = r - c + (N - 1);
        int rd = r + c;
        if (!crossVisited[0][ld] && !crossVisited[1][rd]) {
            crossVisited[0][ld] = true;
            crossVisited[1][rd] = true;
            func(idx + 1, cnt + 1, list);
            crossVisited[0][ld] = false;
            crossVisited[1][rd] = false;
        }
        func(idx + 1, cnt, list);
    }
}