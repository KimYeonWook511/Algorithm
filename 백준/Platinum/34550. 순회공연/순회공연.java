import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int A[] = new int[N];
        int S[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int LOG = 1;
		while ((1 << LOG) <= N - 1) {
			LOG++;
		}
        int next[][] = new int[LOG][N]; // v에서 출발해서 2^k일 뒤 도착하는 도시
        // 1일 뒤 도시
        for (int v = 0; v < N; v++) {
            next[0][v] = A[v];
        }
        // 2^k일 뒤 도시
        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < N; v++) {
                next[k][v] = next[k - 1][next[k - 1][v]];
            }
        }

        int left = 1;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt[] = new int[N];
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                int end = jump(S[i], mid, next, LOG);

                if (++cnt[end] >= K) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left > N ? -1 : left);

        br.close();
    }

    static int jump(int start, int mid, int next[][], int LOG) {
        int day = mid - 1;
        int cur = start;
        for (int k = 0; k < LOG; k++) {
            if (((1 << k) & day) == 0) continue;

            cur = next[k][cur];
        }
        return cur;
    }
}