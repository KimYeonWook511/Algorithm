import java.io.*;
import java.util.*;

public class Main {
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left[] = new long[4_000_001];
        long right[] = new long[4_000_001];

        func(0, N / 2, 2_000_000, left);
        func(N / 2, N, 2_000_000, right);

        long answer = 0;
        for (int i = 0; i <= 4_000_000; i++) {
            int rIndex = 4_000_000 - i + S;
            if (0 <= rIndex && rIndex <= 4_000_000) {
                answer += (left[i] * right[rIndex]);
            }
        }

        if (S == 0) {
            // 아예 안 고르는 경우의 수 빼기
            answer--;
        }
        
        System.out.println(answer);

        br.close();
    }

    static void func(int cur, int end, int sum, long count[]) {
        if (cur == end) {
            count[sum]++;
            return;
        }

        func(cur + 1, end, sum + arr[cur], count);
        func(cur + 1, end, sum, count);
    }
}