import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int B[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int startA = 0;
        int startB = 0;
        StringBuilder sb = new StringBuilder();
        while (startA < N && startB < M) {
            int max = 0;
            int indexA = 0;
            int indexB = 0;
            for (int a = startA; a < N; a++) {
                for (int b = startB; b < M; b++) {
                    if (A[a] == B[b] && max < A[a]) {
                        max = A[a];
                        indexA = a;
                        indexB = b;
                    }
                }
            }

            if (max == 0) break;

            startA = indexA + 1;
            startB = indexB + 1;
            cnt++;
            sb.append(max).append(" ");
        }

        System.out.println(cnt);
        System.out.println(sb);

        br.close();
    }
}