import java.io.*;
import java.util.*;

public class Main {
    static boolean gears[][] = new boolean[4][8]; // false: N | true: S
    static int tops[] = new int[4]; // default 0

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String gear = br.readLine();
            for (int k = 0; k < 8; k++) {
                gears[i][k] = gear.charAt(k) == '1';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken()) - 1;
            boolean isClockwise = st.nextToken().charAt(0) == '1';

            // 왼쪽
            leftSpin(cur, isClockwise);

            // 오른쪽
            rightSpin(cur, isClockwise);

            if (isClockwise) {
                tops[cur] = (tops[cur] + 7) % 8;
            } else {
                tops[cur] = (tops[cur] + 1) % 8;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][tops[i]]) {
                answer += (1 << i);
            }
        }

        System.out.println(answer);

        br.close();
    }

    static void leftSpin(int cur, boolean isClockwise) {
        if (cur == 0) return;
        if (gears[cur - 1][(tops[cur - 1] + 2) % 8] == gears[cur][(tops[cur] + 6) % 8]) return;

        // 왼쪽 톱니바퀴 돌아감
        leftSpin(cur - 1, !isClockwise);

        // 왼쪽 톱니바퀴 돌리기
        if (isClockwise) {
            tops[cur - 1] = (tops[cur - 1] + 1) % 8;
        } else {
            tops[cur - 1] = (tops[cur - 1] + 7) % 8;
        }
    }

    static void rightSpin(int cur, boolean isClockwise) {
        if (cur == 3) return;
        if (gears[cur][(tops[cur] + 2) % 8] == gears[cur + 1][(tops[cur + 1] + 6) % 8]) return;

        // 오른쪽 톱니바퀴 돌아감
        rightSpin(cur + 1, !isClockwise);

        // 오른쪽 톱니바퀴 돌리기
        if (isClockwise) {
            tops[cur + 1] = (tops[cur + 1] + 1) % 8;
        } else {
            tops[cur + 1] = (tops[cur + 1] + 7) % 8;
        }
    }
}