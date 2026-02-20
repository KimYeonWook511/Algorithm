import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;

        Point (long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point L1, L2;

        Line(Point L1, Point L2) {
            this.L1 = L1;
            this.L2 = L2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Line lines[] = new Line[2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            Point L1 = new Point(x1, y1);
            Point L2 = new Point(x2, y2);
            lines[i] = new Line(L1, L2);
        }

        int ccw1 = ccw(lines[0].L1, lines[0].L2, lines[1].L1) * ccw(lines[0].L1, lines[0].L2, lines[1].L2);
        int ccw2 = ccw(lines[1].L1, lines[1].L2, lines[0].L1) * ccw(lines[1].L1, lines[1].L2, lines[0].L2);

        // 세 점이 일직선 위에 있는 경우는 없음
        System.out.println((ccw1 < 0 && ccw2 < 0) ? 1 : 0);

        br.close();
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long val = ((p2.x - p1.x) * (p3.y - p1.y)) - ((p2.y - p1.y) * (p3.x - p1.x));
		// 반시계 (val > 0)
		// 시계 (val < 0)
		// 직선 (val == 0) -> (이 문제에서 존재하지 않음)
		return Long.compare(val, 0);
    }
}