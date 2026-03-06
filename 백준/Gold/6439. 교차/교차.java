import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Point start = new Point(startX, startY);
            Point end = new Point(endX, endY);
            Point leftTop = new Point(Math.min(x1, x2), Math.max(y1, y2));
            Point rightTop = new Point(Math.max(x1, x2), Math.max(y1, y2));
            Point leftBottom = new Point(Math.min(x1, x2), Math.min(y1, y2));
            Point rightBottom = new Point(Math.max(x1, x2), Math.min(y1, y2));

            boolean answer = false;
            if (check(start, end, leftTop, rightTop)) {
                answer = true;
            } else if (check(start, end, leftBottom, rightBottom)) {
                answer = true;
            } else if (check(start, end, leftTop, leftBottom)) {
                answer = true;
            } else if (check(start, end, rightTop, rightBottom)) {
                answer = true;
            } else if (isIntersect(start, end, leftTop.x, rightBottom.x, leftTop.y, rightBottom.y)) {
                // 선분이 사각형 안에 있을때
                answer = true;
            }

            sb.append(answer ? "T\n" : "F\n");
        }

        System.out.println(sb);

        br.close();
    }

    static boolean check(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = getCCW(p1, p2, p3) * getCCW(p1, p2, p4);
        int ccw2 = getCCW(p3, p4, p1) * getCCW(p3, p4, p2);

        if (ccw1 == 0 && ccw2 == 0) {
			return isIntersect(p1, p2, p3, p4);
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            // 교차
            return true;
        } else {
            // 교차하지 않음
            return false;
        }
    }

    static int getCCW(Point p1, Point p2, Point p3) {
        int val = ((p2.x - p1.x) * (p3.y - p1.y)) - ((p2.y - p1.y) * (p3.x - p1.x));
        return Integer.compare(val, 0);
    }

    static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        return Math.max(p1.x, p2.x) >= Math.min(p3.x, p4.x)
            && Math.max(p3.x, p4.x) >= Math.min(p1.x, p2.x)
            && Math.max(p1.y, p2.y) >= Math.min(p3.y, p4.y)
            && Math.max(p3.y, p4.y) >= Math.min(p1.y, p2.y);
    }

    static boolean isIntersect(Point p1, Point p2, int left, int right, int top, int bottom) {
        return Math.min(p1.x, p2.x) >= left
            && Math.max(p1.x, p2.x) <= right
            && Math.min(p1.y, p2.y) >= bottom
            && Math.max(p1.y, p2.y) <= top;
    }
}