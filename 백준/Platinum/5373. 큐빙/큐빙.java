import java.io.*;
import java.util.*;

public class Main {
    static char cube[][] = new char[6][9]; // F R B L U D

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            initCube();

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String cmd = st.nextToken();
                char d = cmd.charAt(0);
                boolean isCircle = cmd.charAt(1) == '+';

                spin(d, isCircle);
            }

            // 윗 면 출력
            for (int i = 0; i < 9; i++) {
                sb.append(cube[4][i]);
                if ((i + 1) % 3 == 0) {
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);

        br.close();
    }

    static void initCube() {
        // F
        for (int i = 0; i < 9; i++) {
            cube[0][i] = 'r';
        }
        // R
        for (int i = 0; i < 9; i++) {
            cube[1][i] = 'b';
        }
        // B
        for (int i = 0; i < 9; i++) {
            cube[2][i] = 'o';
        }
        // L
        for (int i = 0; i < 9; i++) {
            cube[3][i] = 'g';
        }
        // U
        for (int i = 0; i < 9; i++) {
            cube[4][i] = 'w';
        }
        // D
        for (int i = 0; i < 9; i++) {
            cube[5][i] = 'y';
        }
    }

    static void spin(char d, boolean isCircle) {
        if (d == 'F') {
            spinF(isCircle);
        } else if (d == 'R') {
            spinR(isCircle);
        } else if (d == 'B') {
            spinB(isCircle);
        } else if (d == 'L') {
            spinL(isCircle);
        } else if (d == 'U') {
            spinU(isCircle);
        } else if (d == 'D') {
            spinD(isCircle);
        }
    }

    static void spinF(boolean isCircle) {
        ss(0, isCircle);
        if (isCircle) {
            char temp = cube[4][6];
            cube[4][6] = cube[3][8];
            cube[3][8] = cube[5][2];
            cube[5][2] = cube[1][0];
            cube[1][0] = temp;

            temp = cube[4][7];
            cube[4][7] = cube[3][5];
            cube[3][5] = cube[5][1];
            cube[5][1] = cube[1][3];
            cube[1][3] = temp;

            temp = cube[4][8];
            cube[4][8] = cube[3][2];
            cube[3][2] = cube[5][0];
            cube[5][0] = cube[1][6];
            cube[1][6] = temp;
        } else {
            char temp = cube[1][0];
            cube[1][0] = cube[5][2];
            cube[5][2] = cube[3][8];
            cube[3][8] = cube[4][6];
            cube[4][6] = temp;

            temp = cube[1][3];
            cube[1][3] = cube[5][1];
            cube[5][1] = cube[3][5];
            cube[3][5] = cube[4][7];
            cube[4][7] = temp;

            temp = cube[1][6];
            cube[1][6] = cube[5][0];
            cube[5][0] = cube[3][2];
            cube[3][2] = cube[4][8];
            cube[4][8] = temp;
        }
    }

    static void spinR(boolean isCircle) {
        ss(1, isCircle);
        if (isCircle) {
            char temp = cube[4][8];
            cube[4][8] = cube[0][8];
            cube[0][8] = cube[5][8];
            cube[5][8] = cube[2][0];
            cube[2][0] = temp;

            temp = cube[4][5];
            cube[4][5] = cube[0][5];
            cube[0][5] = cube[5][5];
            cube[5][5] = cube[2][3];
            cube[2][3] = temp;

            temp = cube[4][2];
            cube[4][2] = cube[0][2];
            cube[0][2] = cube[5][2];
            cube[5][2] = cube[2][6];
            cube[2][6] = temp;
        } else {
            char temp = cube[2][0];
            cube[2][0] = cube[5][8];
            cube[5][8] = cube[0][8];
            cube[0][8] = cube[4][8];
            cube[4][8] = temp;

            temp = cube[2][3];
            cube[2][3] = cube[5][5];
            cube[5][5] = cube[0][5];
            cube[0][5] = cube[4][5];
            cube[4][5] = temp;

            temp = cube[2][6];
            cube[2][6] = cube[5][2];
            cube[5][2] = cube[0][2];
            cube[0][2] = cube[4][2];
            cube[4][2] = temp;
        }
    }

    static void spinB(boolean isCircle) {
        ss(2, isCircle);
        if (isCircle) {
            char temp = cube[4][2];
            cube[4][2] = cube[1][8];
            cube[1][8] = cube[5][6];
            cube[5][6] = cube[3][0];
            cube[3][0] = temp;

            temp = cube[4][1];
            cube[4][1] = cube[1][5];
            cube[1][5] = cube[5][7];
            cube[5][7] = cube[3][3];
            cube[3][3] = temp;

            temp = cube[4][0];
            cube[4][0] = cube[1][2];
            cube[1][2] = cube[5][8];
            cube[5][8] = cube[3][6];
            cube[3][6] = temp;
        } else {
            char temp = cube[3][0];
            cube[3][0] = cube[5][6];
            cube[5][6] = cube[1][8];
            cube[1][8] = cube[4][2];
            cube[4][2] = temp;

            temp = cube[3][3];
            cube[3][3] = cube[5][7];
            cube[5][7] = cube[1][5];
            cube[1][5] = cube[4][1];
            cube[4][1] = temp;

            temp = cube[3][6];
            cube[3][6] = cube[5][8];
            cube[5][8] = cube[1][2];
            cube[1][2] = cube[4][0];
            cube[4][0] = temp;
        }
    }

    static void spinL(boolean isCircle) {
        ss(3, isCircle);
        if (isCircle) {
            char temp = cube[4][0];
            cube[4][0] = cube[2][8];
            cube[2][8] = cube[5][0];
            cube[5][0] = cube[0][0];
            cube[0][0] = temp;

            temp = cube[4][3];
            cube[4][3] = cube[2][5];
            cube[2][5] = cube[5][3];
            cube[5][3] = cube[0][3];
            cube[0][3] = temp;

            temp = cube[4][6];
            cube[4][6] = cube[2][2];
            cube[2][2] = cube[5][6];
            cube[5][6] = cube[0][6];
            cube[0][6] = temp;
        } else {
            char temp = cube[0][0];
            cube[0][0] = cube[5][0];
            cube[5][0] = cube[2][8];
            cube[2][8] = cube[4][0];
            cube[4][0] = temp;

            temp = cube[0][3];
            cube[0][3] = cube[5][3];
            cube[5][3] = cube[2][5];
            cube[2][5] = cube[4][3];
            cube[4][3] = temp;

            temp = cube[0][6];
            cube[0][6] = cube[5][6];
            cube[5][6] = cube[2][2];
            cube[2][2] = cube[4][6];
            cube[4][6] = temp;
        }
    }

    static void spinU(boolean isCircle) {
        ss(4, isCircle);
        if (isCircle) {
            char temp = cube[2][2];
            cube[2][2] = cube[3][2];
            cube[3][2] = cube[0][2];
            cube[0][2] = cube[1][2];
            cube[1][2] = temp;

            temp = cube[2][1];
            cube[2][1] = cube[3][1];
            cube[3][1] = cube[0][1];
            cube[0][1] = cube[1][1];
            cube[1][1] = temp;

            temp = cube[2][0];
            cube[2][0] = cube[3][0];
            cube[3][0] = cube[0][0];
            cube[0][0] = cube[1][0];
            cube[1][0] = temp;
        } else {
            char temp = cube[1][2];
            cube[1][2] = cube[0][2];
            cube[0][2] = cube[3][2];
            cube[3][2] = cube[2][2];
            cube[2][2] = temp;

            temp = cube[1][1];
            cube[1][1] = cube[0][1];
            cube[0][1] = cube[3][1];
            cube[3][1] = cube[2][1];
            cube[2][1] = temp;

            temp = cube[1][0];
            cube[1][0] = cube[0][0];
            cube[0][0] = cube[3][0];
            cube[3][0] = cube[2][0];
            cube[2][0] = temp;
        }
    }

    static void spinD(boolean isCircle) {
        ss(5, isCircle);
        if (isCircle) {
            char temp = cube[0][6];
            cube[0][6] = cube[3][6];
            cube[3][6] = cube[2][6];
            cube[2][6] = cube[1][6];
            cube[1][6] = temp;

            temp = cube[0][7];
            cube[0][7] = cube[3][7];
            cube[3][7] = cube[2][7];
            cube[2][7] = cube[1][7];
            cube[1][7] = temp;

            temp = cube[0][8];
            cube[0][8] = cube[3][8];
            cube[3][8] = cube[2][8];
            cube[2][8] = cube[1][8];
            cube[1][8] = temp;
        } else {
            char temp = cube[1][6];
            cube[1][6] = cube[2][6];
            cube[2][6] = cube[3][6];
            cube[3][6] = cube[0][6];
            cube[0][6] = temp;

            temp = cube[1][7];
            cube[1][7] = cube[2][7];
            cube[2][7] = cube[3][7];
            cube[3][7] = cube[0][7];
            cube[0][7] = temp;

            temp = cube[1][8];
            cube[1][8] = cube[2][8];
            cube[2][8] = cube[3][8];
            cube[3][8] = cube[0][8];
            cube[0][8] = temp;
        }
    }

    static void ss(int d, boolean isCircle) {
        if (isCircle) {
            // 2 -> 8 -> 6 -> 0 -> 2
            char temp = cube[d][2];
            cube[d][2] = cube[d][0];
            cube[d][0] = cube[d][6];
            cube[d][6] = cube[d][8];
            cube[d][8] = temp;
            // 1 -> 5 -> 7 -> 3 -> 1
            temp = cube[d][1];
            cube[d][1] = cube[d][3];
            cube[d][3] = cube[d][7];
            cube[d][7] = cube[d][5];
            cube[d][5] = temp;
        } else {
            // 0 -> 6 -> 8 -> 2 -> 0
            char temp = cube[d][0];
            cube[d][0] = cube[d][2];
            cube[d][2] = cube[d][8];
            cube[d][8] = cube[d][6];
            cube[d][6] = temp;
            // 1 -> 3 -> 7 -> 5 -> 1
            temp = cube[d][1];
            cube[d][1] = cube[d][5];
            cube[d][5] = cube[d][7];
            cube[d][7] = cube[d][3];
            cube[d][3] = temp;
        }
    }
}