import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 1];
        int sum[] = new int[N + 1];
        arr[0] = 1;
        sum[0] = 1;

        for (int i = 1; i <= N; i++) {
            int left = i - b + 1;
            int right = i - a;

            int val = 0;
            if (right >= 0) {
                val = sum[right];
                if (left - 1 >= 0) {
                    val -= sum[left - 1];
                }
                val %= MOD;
                if (val < 0) val += MOD;
            }

            arr[i] = val;
            sum[i] = (sum[i - 1] + arr[i]) % MOD;
        }

        int answer = sum[N];
        if (N - d >= 0) {
            answer -= sum[N - d];
        }
        answer %= MOD;
        if (answer < 0) answer += MOD;

        System.out.println(answer);

        br.close();
    }
}