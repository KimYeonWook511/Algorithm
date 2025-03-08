import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        int sum[] = new int[N + 1];
        int revSum[] = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
            revSum[N + 1 - i] = revSum[N + 2 - i] + arr[N + 1 - i];
        }

        int max = 0;
        for (int i = N - 1; i > 1; i--) {
            // 꿀통이 맨 우측에 있는 경우
            max = Math.max(max, (sum[N] - sum[1]) + (sum[N] - sum[i]) - (sum[i] - sum[i - 1]));

            // 꿀통이 맨 좌측에 있는 경우
            max = Math.max(max, (revSum[1] - revSum[N]) + (revSum[1] - revSum[i]) - (revSum[i] - revSum[i + 1]));

            // 꿀통이 중간에 있는 경우
            max = Math.max(max, (sum[i] - sum[1]) + (revSum[i] - revSum[N]));
        }

        System.out.println(max);

        br.close();
    }
}