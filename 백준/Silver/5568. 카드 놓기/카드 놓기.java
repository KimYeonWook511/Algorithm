import java.io.*;
import java.util.*;

public class Main {
    static int n, k, arr[];
    static Set<Integer> set = new HashSet<>();
    static boolean chk[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        chk = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        func(k, "");

        System.out.println(set.size());

        br.close();
    }

    static void func(int cnt, String num) {
        if (cnt == 0) {
            set.add(Integer.parseInt(num));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                chk[i] = true;
                func(cnt - 1, num + arr[i]);
                chk[i] = false;
            }
        }
    }
}