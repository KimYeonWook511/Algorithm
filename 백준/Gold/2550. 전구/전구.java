import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int switches[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int bulbs[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bulbs[Integer.parseInt(st.nextToken())] = i;
        }

        int dp[] = new int[N + 1];
        int dpIndex[] = new int[N + 1];
        int len = 0;
        for (int i = 1; i <= N; i++) {
            int left = 1;
            int right = len;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (dp[mid] >= bulbs[switches[i]]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            dp[left] = bulbs[switches[i]];
            dpIndex[i] = left;
            if (left > len) {
                len++;
            }
        }

        int result[] = new int[len];
        for (int i = N; i >= 1; i--) {
            if (dpIndex[i] == len) {
                result[len - 1] = switches[i];
                if (--len == 0) break;
            }
        }

        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.length).append("\n");
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}