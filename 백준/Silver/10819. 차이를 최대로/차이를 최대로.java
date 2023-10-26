import java.io.*;
import java.util.*;

public class Main {
    static int n, max;
    static int arr[], result[];
    static boolean chk[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[n];
        result = new int[n];
        chk = new boolean[n];
        max = -800;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0);

        System.out.println(max);

        br.close();
    }

    static void func(int cnt) {
        if (cnt == n) {
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }

            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                result[cnt] = arr[i];
                chk[i] = true;
                func(cnt + 1);
                chk[i] = false;
            }
        }
    }
}