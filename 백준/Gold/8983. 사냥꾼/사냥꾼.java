import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;

        for (int run = 0; run < N; run++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gap = L - y;

            if (gap < 0) continue;

            int min = x - gap;
            int max = x + gap;

            int left = 0;
            int right = M - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] < min) left = mid + 1;
                else if (arr[mid] > max) right = mid - 1;
                else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}