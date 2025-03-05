import java.io.*;
import java.util.*;

public class Main {
    static int N, gap[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        gap = new int[N];
        long aSum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            aSum += A;
            gap[i] = B - A;
        }

        Arrays.sort(gap);
        long gapSum[] = new long[N + 1];
        for (int i = 0; i < N; i++) {
            gapSum[i + 1] = gapSum[i] + gap[i];
        }

        int Q = Integer.parseInt(br.readLine());
        long X[] = new long[2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            X[ch == 'A' ? 0 : 1] += num;

            int idx = binarySearch(N, gap, X[0] - X[1]);

            long gapBMax = gapSum[N] - gapSum[idx];
            int cntBMax = N - idx;

            sb.append(aSum + (X[0] * N) + gapBMax - (cntBMax * (X[0] - X[1]))).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int binarySearch(int N, int gap[], long findVal) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (gap[mid] > findVal) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}