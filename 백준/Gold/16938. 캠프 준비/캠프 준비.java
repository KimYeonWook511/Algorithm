import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, X;
    static int A[], answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        func(0, Integer.MAX_VALUE, 0, 0, 0);

        System.out.println(answer);

        br.close();
    }

    static void func(int i, int min, int max, int sum, int cnt) {
        if (sum > R) return;
        if (i == N) {
            if (sum >= L && (max - min) >= X && cnt >= 2) answer++;
            return;
        }

        func(i + 1, Math.min(min, A[i]), Math.max(max, A[i]), sum + A[i], cnt + 1);
        func(i + 1, min, max, sum, cnt);
    }
}