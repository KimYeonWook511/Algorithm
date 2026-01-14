import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N];
        int topIndex = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = topIndex;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            dp[left] = num;

            if (left > topIndex) {
                topIndex = left; // +1
            }
        }

        System.out.println(N - (topIndex + 1));

        br.close();
    }
}