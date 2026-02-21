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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        Point A = new Point(x1, y1);
        Point B = new Point(x2, y2);
        Point C = new Point(x3, y3);
        Point D = new Point(x4, y4);

        int ccw1 = ccw(A, B, C) * ccw(A, B, D);
        int ccw2 = ccw(C, D, A) * ccw(C, D, B);

        if (ccw1 == 0 && ccw2 == 0) {
            if (isIntersect(A, B, C, D)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long val =((p2.x - p1.x) * (p3.y - p1.y)) - ((p2.y - p1.y) * (p3.x - p1.x));
        return Long.compare(val, 0L);
    }

    static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        return Math.max(p1.x, p2.x) >= Math.min(p3.x, p4.x)
            && Math.max(p3.x, p4.x) >= Math.min(p1.x, p2.x)
            && Math.max(p1.y, p2.y) >= Math.min(p3.y, p4.y)
            && Math.max(p3.y, p4.y) >= Math.min(p1.y, p2.y);
    }
}
