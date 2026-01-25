import java.io.*;
import java.util.*;

public class Main {
    static class Rectangle {
        int x1, y1; // 좌하단
        int x2, y2; // 우상단

        Rectangle (int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static int parents[];
    static int ranks[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Rectangle arr[] = new Rectangle[N + 1];
        arr[0] = new Rectangle(0, 0, 0, 0);
        parents = new int[N + 1];
        ranks = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            arr[i] = new Rectangle(x1, y1, x2, y2);
            parents[i] = i;

            for (int k = 0; k < i; k++) {
                if (isIntersects(arr[k], arr[i])) {
                    union(k, i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= N; i++) {
            if (find(i) == i) {
                answer++;
            }
        }

        System.out.println(answer - 1);

        br.close();
    }

    static boolean isIntersects(Rectangle a, Rectangle b) {
        // 서로 밖에 있음
        if (a.x2 < b.x1 || b.x2 < a.x1) {
            return false;
        }
        if (a.y2 < b.y1 || b.y2 < a.y1) {
            return false;
        }

        // 내부에 있는 경우
        if (a.x1 < b.x1 && b.x2 < a.x2 && a.y1 < b.y1 && b.y2 < a.y2) {
            return false;
        }
        if (b.x1 < a.x1 && a.x2 < b.x2 && b.y1 < a.y1 && a.y2 < b.y2) {
            return false;
        }

        return true;
    }

    static int find(int x) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (ranks[x] < ranks[y]) {
            parents[x] = y;
        } else if (ranks[x] > ranks[y]) {
            parents[y] = x;
        } else {
            parents[y] = x;
            ranks[x]++;
        }
    }
}