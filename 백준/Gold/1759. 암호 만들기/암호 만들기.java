import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char arr[], result[];
    static boolean aeiou[], chk[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        aeiou = new boolean[C];
        chk = new boolean[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        for (int i = 0; i < C; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') aeiou[i] = true;
        }

        func(0, 0, 0, 0);

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int len, int idx, int consonantCnt, int vowelCnt) {
        if (len == L) {
            if (consonantCnt >= 2 && vowelCnt >= 1) {
                for (int i = 0; i < len; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = idx; i <= C - L + len; i++) {
            if (chk[i]) continue;

            chk[i] = true;
            result[len] = arr[i];
            if (aeiou[i]) func(len + 1, i + 1, consonantCnt, vowelCnt + 1);
            else func(len + 1, i + 1, consonantCnt + 1, vowelCnt);
            chk[i] = false;
        }
    }
}