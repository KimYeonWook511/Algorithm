import java.io.*;

public class Main {
    static int N, arr[] = { 1, 5, 10, 50 }, result;
    static boolean chk[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chk = new boolean[50 * N + 1];

        func(0, 0, 0);

        System.out.println(result);

        br.close();
    }
    
    static void func(int cnt, int startIdx, int val) {
        if (cnt == N) {
            if (!chk[val]) {
                chk[val] = true;
                result++;
            }

            return;
        }

        for (int i = startIdx; i < 4; i++) {
            func(cnt + 1, i, val + arr[i]);
        }
    }
}