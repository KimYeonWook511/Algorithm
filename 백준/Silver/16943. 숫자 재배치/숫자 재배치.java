import java.io.*;
import java.util.*;

public class Main {
    static String A, B;
    static int lenA, lenB;
    static int cnt[] = new int[10];
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        lenA = A.length();
        lenB = B.length();
        
        if (lenA == lenB) {
            for (int i = 0; i < lenA; i++) {
                cnt[A.charAt(i) - '0']++;
            }

            for (int num = B.charAt(0) - '0'; num > 0; num--) {
                if (cnt[num] == 0) continue;
                
                cnt[num]--;
                func(1, num, B.charAt(0) - '0');
                cnt[num]++;
            }

        } else if (lenA < lenB) {
            for (int i = 0; i < lenA; i++) {
                cnt[A.charAt(i) - '0']++;
            }

            result = 0;
            for (int num = 9; num >= 0; num--) {
                if (cnt[num] == 0) continue;

                result *= 10;
                result += num;
                cnt[num]--;
                num++;
            }
        }

        System.out.println(result);

        br.close();
    }

    static void func(int i, int C, int numB) {
        if (result != -1) return;
        if (C > numB) return;
        
        if (i == lenA) {
            if (C < numB) result = C;
            return;
        }

        for (int num = 9; num >= 0; num--) {
            if (cnt[num] == 0) continue;

            cnt[num]--;
            func(i + 1, C * 10 + num, numB * 10 + B.charAt(i) - '0');
            cnt[num]++;
        }
    }
}