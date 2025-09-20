import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= N - 1; i++) {
            for (int k = i + 1; k <= N; k++) {
                // |(sum[k] - sum[target]) - (sum[target] - sum[i - 1])| = |sum[k] + sum[i - 1] - (2 * sum[target])|
                int val = sum[k] + sum[i - 1];
                int left = i;
                int right = k - 1;
                while (left <= right) {
                    int mid = (left + right) >> 1;

                    if ((sum[mid] << 1) < val) left = mid + 1;
                    else right = mid - 1;
                }

                // left를 기준으로 왼쪽과 오른쪽 검사
                for (int d = 0; d < 2; d++) {
                    int target = left - d;
                    if (target < i || target > k - 1) continue;

                    int A = sum[k] - sum[target];
                    int B = sum[target] - sum[i - 1];
                    int E = Math.abs(A - B);

                    if (E < min) {
                        min = E;
                        result = A + B;
                    } else if (E == min) {
                        result = Math.max(result, A + B);
                    }
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}