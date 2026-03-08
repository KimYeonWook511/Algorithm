import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            int count = 1;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (count <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(left).append("\n");

        int sum = 0;
        int cnt = 0;
        int answerCnt = 0;
        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > left) {
                sb.append(cnt).append(" ");
                sum = 0;
                cnt = 0;
                answerCnt++;
            }

            if (M - answerCnt == N - i) {
                // 남은 구슬을 1개씩 그룹 처리 하기 위함
                sum = left;
            }

            sum += arr[i];
            cnt++;
        }
        sb.append(cnt);

        System.out.println(sb);

        br.close();
    }
}