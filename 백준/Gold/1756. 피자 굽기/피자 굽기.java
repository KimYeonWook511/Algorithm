import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[D + 1];
        arr[0] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            int oven = Integer.parseInt(st.nextToken());
            arr[i] = Math.min(oven, arr[i - 1]);
        }

        int lastIndex = D + 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pizza = Integer.parseInt(st.nextToken());

            // 내림차순
            int left = 1;
            int right = lastIndex - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= pizza) left = mid + 1;
                else right = mid - 1;
            }

            lastIndex = right;
            if (lastIndex == 0) break;
        }

        System.out.println(lastIndex);

        br.close();
    }
}