import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start = bs1(start);
            end = bs2(end);

            sb.append(end - start).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    static int bs1(int k) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= k) right = mid - 1;
            else left = mid + 1;
        }

        return right + 1;
    }

    static int bs2(int k) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > k) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}