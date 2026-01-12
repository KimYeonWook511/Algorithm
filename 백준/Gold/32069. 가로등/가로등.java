import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long arr[] = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int sum[] = new int[K + 2]; // 누적합
        int count[] = new int[K + 2]; // 개수
        count[0] += N; // 가로등 자리

        // 왼쪽
        if (arr[0] != 0) {
            int min = (int)Math.min(arr[0], K);
            sum[1]++;
            sum[min + 1]--;
        }
        // 오른쪽
        if (arr[N - 1] != L) {
            int min = (int)Math.min(L - arr[N - 1], K);
            sum[1]++;
            sum[min + 1]--;
        }

        for (int i = 1; i < arr.length; i++) {
            long dist = arr[i] - arr[i - 1] - 1;
            if (dist == 0) continue; // 가로등 붙어있음

            int maxHalfDist = (int)Math.min(dist / 2, K); // K가 최대
            if ((dist & 1L) == 0) {
                // 짝수
                sum[1] += 2;
                sum[maxHalfDist + 1] -= 2;
            } else {
                // 홀수
                if (maxHalfDist > 0) {
                    sum[1] += 2;
                    sum[maxHalfDist + 1] -= 2;
                }
                count[maxHalfDist + 1] += 1; // 중간 거리 하나 추가
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < count[0]; k++) {
            sb.append(0).append("\n");
            if (--K == 0) break;
        }
        for (int i = 1; i < count.length; i++) {
            if (K == 0) break;
            sum[i] += sum[i - 1];
            count[i] += sum[i];

            for (int k = 0; k < count[i]; k++) {
                sb.append(i).append("\n");
                if (--K == 0) break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}