import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int B[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);

        int max = 0;
        boolean visited[] = new boolean[40_001]; // -20,000<=A<=20,000
        for (int i = 0; i < N; i++) {
            for (int k = i + 1; k < N; k++) {
                int bottom = Math.abs(A[i] - A[k]);

                if (visited[bottom]) continue;
                visited[bottom] = true;

                int index = binarySearch(R, bottom, B);
                if (index == -1) continue;

                max = Math.max(max, bottom * B[index]);
            }
        }

        if (max == 0) System.out.println(-1);
        else System.out.println(String.format("%.1f", max / 2.0));

        br.close();
    }

    static int binarySearch(int R, int bottom, int B[]) {
        int R_2 = R << 1;
        int left = 0;
        int right = B.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (bottom * B[mid] <= R_2) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}