import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        int cnt[] = new int[100001];
        int left = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int right = 0; right < N; right++) {
            arr[right] = Integer.parseInt(st.nextToken());

            if (++cnt[arr[right]] > M) {
                while (true) {
                    cnt[arr[left]]--;

                    if (arr[left++] == arr[right]) break;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);

        br.close();
    }
}