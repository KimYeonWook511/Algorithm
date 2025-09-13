import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean arr[] = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int result = 0;
        while (right < N) {
            if (arr[right]) {
                right++;
                result = Math.max(result, right - left - cnt);
                continue;
            }

            if (cnt < K) {
                right++;
                cnt++;
                continue;
            }

            if (!arr[left]) cnt--;
            left++;
        }

        System.out.println(result);
        
        br.close();
    }
}