import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int target = getClockNum(up, right, down, left);

        int answer = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        int origin = a * 1000 + b * 100 + c * 10 + d;
                        int clockNum = getClockNum(a, b, c, d);

                        if (origin != clockNum) continue;

                        if (clockNum <= target) {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    static int getClockNum(int a, int b, int c, int d) {
        int n1 = a * 1000 + b * 100 + c * 10 + d;
        int n2 = b * 1000 + c * 100 + d * 10 + a;
        int n3 = c * 1000 + d * 100 + a * 10 + b;
        int n4 = d * 1000 + a * 100 + b * 10 + c;

        return Math.min(Math.min(n1, n2), Math.min(n3, n4));
    }
}
