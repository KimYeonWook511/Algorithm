import java.io.*;
import java.util.*;

public class Main {
    static int arr[] = new int[10];
    static int map[] = new int[61];
    static int score[] = new int[61];
    static int max = 0;
    static int point[] = new int[4];
    static boolean chk[] = new boolean[61];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initMap();
        initScore();
        func(0, 0);

        System.out.println(max);
        
        br.close();
    }

    static void func(int idx, int sum) {
        if (idx == 10) {
            max = Math.max(max, sum);
            return;
        }

        for (int p = 0; p < 4; p++) {
            if (point[p] == 26) continue;

            int move = point[p] + arr[idx];
            int nextPoint = map[move];

            if (nextPoint != 26 && chk[nextPoint]) continue;

            int temp = point[p];
            chk[temp] = false;
            point[p] = nextPoint;
            chk[nextPoint] = true;
            func(idx + 1, sum + score[nextPoint]);
            chk[nextPoint] = false;
            point[p] = temp;
            chk[temp] = true;
        }
    }

    static void initMap() {
        // 지도 구조
        // 0(시작) 1 2 ... 18 19 20 21(26) 22(26) 23(26) 24(26) 25(26) 26(도착) // 둘레
        // 5(30)  -> 31 32 33 34(53) 35(54) 36(55) 37(20) 38(26) // 5지름길
        // 10(50) -> 51 52 53 54 55 56(20) 57(26) 58(26) 59(26) 60(26) // 10지름길
        // 15(40) -> 41 42 43 44(53) 45(54) 46(55) 47(20) 48(26) // 15지름길
        
        for (int i = 1; i <= 20; i++) {
            map[i] = i;
        }

        map[5] = 30;
        map[10] = 50;
        map[15] = 40;

        map[37] = map[47] = map[56] = 20;
        map[38] = map[48] = map[57] = map[58] = map[59] = map[60] = 26;

        for (int i = 31; i <= 33; i++) {
            map[i] = i;
            map[i + 20] = i + 20;
            map[i + 10] = i + 10;
        }

        for (int i = 53; i <= 55; i++) {
            map[i - 19] = i;
            map[i] = i;
            map[i - 9] = i;
        }

        for (int i = 21; i <= 25; i++) {
            map[i] = 26;
        }
    }

    static void initScore() {
        for (int i = 1; i <= 20; i++) {
            score[i] = i << 1;
        }

        score[30] = 10;
        score[31] = 13;
        score[32] = 16;
        score[33] = 19;

        score[50] = 20;
        score[51] = 22;
        score[52] = 24;
        score[53] = 25;
        score[54] = 30;
        score[55] = 35;

        score[40] = 30;
        score[41] = 28;
        score[42] = 27;
        score[43] = 26;
    }
}