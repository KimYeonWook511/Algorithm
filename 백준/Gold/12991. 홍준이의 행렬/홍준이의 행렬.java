import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int B[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 홍준이는 이 원소들을 모두 정렬하였다는게 이걸 정렬한것인가?
        Arrays.sort(A);
        Arrays.sort(B);

        long left = 1L * A[0] * B[0];
        long right = 1L * A[N - 1] * B[N - 1];
        while (left <= right) { // max log10억*10억 == log10^18 == log2^60 == 60
            long mid = (left + right) >> 1;

            int k = 0;
            int b = N - 1;
            for (int i = 0; i < N; i++) { // max 30000
                while (b >= 0) {
                    if (1L * A[i] * B[b] <= mid) break; // 혹은 A[i] <= mid / B[b]

                    b--;
                }

                k += b + 1;
            }

            if (k < K) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);

        br.close();
    }
}