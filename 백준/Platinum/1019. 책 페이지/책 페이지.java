import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count[] = new int[10];

        int left = 1;
        int right = N;
        int digit = 1;
        while (left <= right) {
            while (true) {
                if (left % 10 == 0) break;
                if (left > right) break;

                cal(left, digit, count);
                left++;
            }

            while (true) {
                if (right % 10 == 9) break;
                if (left > right) break;

                cal(right, digit, count);
                right--;
            }

            if (left > right) break;

            left /= 10;
            right /= 10;
            for (int i = 0; i < 10; i++) {
                count[i] += (right - left + 1) * digit;
            }
            digit *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static void cal(int num, int digit, int count[]) {
        while (num > 0) {
            count[num % 10] += digit;
            num /= 10;
        }
    }
}