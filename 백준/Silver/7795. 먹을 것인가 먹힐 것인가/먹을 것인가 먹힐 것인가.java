import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int A[] = new int[N];
            int B[] = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int sum = 0;

            for (int i = 0; i < N; i++) {
                int left = 0;
                int right = B.length - 1;

                int k = A[i];

                while (left <= right) {
                    int avg = (left + right) / 2;

                    if (B[avg] < k) left = avg + 1;
                    else right = avg - 1;
                }

                sum += left;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}