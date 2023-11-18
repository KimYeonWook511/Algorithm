import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
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

            int max = 0;

            if (N < M) {
                for (int i = M - N; i >= 0; i--) {
                    int sum = 0;

                    for (int k = 0; k < N; k++) {
                        sum += A[k] * B[k + i];
                    }

                    max = Math.max(max, sum);
                }

            } else {
                for (int i = N - M; i >= 0; i--) {
                    int sum = 0;

                    for (int k = 0; k < M; k++) {
                        sum += A[k + i] * B[k];
                    }

                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}