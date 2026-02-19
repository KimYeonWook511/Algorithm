import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pair pairs[] = new Pair[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y);
        }

        int val = ccw(pairs[0], pairs[1], pairs[2]);

        if (val < 0) {
            System.out.println(-1);
        } else if (val > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    static int ccw(Pair p1, Pair p2, Pair p3) {
        return ((p2.x - p1.x) * (p3.y - p1.y)) - ((p2.y - p1.y) * (p3.x - p1.x));
    }
}