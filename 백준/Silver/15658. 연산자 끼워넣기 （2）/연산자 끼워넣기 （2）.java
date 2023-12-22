import java.io.*;
import java.util.*;

public class Main {
    static int N, num[];
    static int op[] = new int[4]; // + - * /
    static int min = 1_000_000_000;
    static int max = -1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        func(1, num[0]);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    static void func(int cnt, int val) {
        if (cnt == N) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            return;
        }

        if (op[0] > 0) {
            op[0]--;
            func(cnt + 1, val + num[cnt]);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            func(cnt + 1, val - num[cnt]);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            func(cnt + 1, val * num[cnt]);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            func(cnt + 1, val / num[cnt]);
            op[3]++;
        }
    }
}