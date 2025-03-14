import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        int B[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) cnt++;
        }

        if (cnt != N) {
            for (int end = N - 1; end > 0; end--) {
                for (int i = 0; i < end; i++) {
                    if (A[i] < A[i + 1]) continue;

                    if (A[i] == B[i]) cnt--;
                    if (A[i + 1] == B[i + 1]) cnt--;

                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;

                    if (A[i] == B[i]) cnt++;
                    if (A[i + 1] == B[i + 1]) cnt++;

                    if (cnt == N) {
                        end = 0;
                        break;
                    }
                }

                if (A[end] != B[end]) break;
            }
        }

        System.out.println(cnt == N ? 1 : 0);

        br.close();
    }
}