import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int numCnt[] = new int[d + 1];
        int cnt = 0; // 중복 개수
        boolean chk = false;

        for (int i = 0; i < k; i++) { // 0 ~ k-1
            int num = arr[i];

            numCnt[num]++;
            if (numCnt[num] != 1) cnt++; // 중복해서 먹은 경우

            if (numCnt[c] != 0) chk = true; // 쿠폰 접시 먹음
        }

        int max = k - cnt + (chk ? 0 : 1);

        for (int i = k; i < N; i++) { // k ~ N-1
            int leftNum = arr[i - k];
            int rightNum = arr[i];

            numCnt[leftNum]--;
            if (numCnt[leftNum] != 0) cnt--;

            numCnt[rightNum]++;
            if (numCnt[rightNum] != 1) cnt++;

            if (numCnt[c] != 0) chk = true; // 쿠폰 접시 먹음
            else chk = false; // 쿠폰 접시 안 먹음

            max = Math.max(max, k - cnt + (chk ? 0 : 1));
        }

        if (N > k) {
            for (int i = 0; i < k; i++) {
                int leftNum = arr[N + i - k];
                int rightNum = arr[i];

                numCnt[leftNum]--;
                if (numCnt[leftNum] != 0) cnt--;

                numCnt[rightNum]++;
                if (numCnt[rightNum] != 1) cnt++;

                if (numCnt[c] != 0) chk = true; // 쿠폰 접시 먹음
                else chk = false; // 쿠폰 접시 안 먹음

                max = Math.max(max, k - cnt + (chk ? 0 : 1));
            }
        }

        System.out.println(max);

        br.close();
    }
}