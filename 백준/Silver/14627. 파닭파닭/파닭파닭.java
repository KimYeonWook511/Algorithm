import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int L[] = new int[S];
        long sum = 0;
        for (int i = 0; i < S; i++) {
            L[i] = Integer.parseInt(br.readLine());
            sum += L[i];
        }

        int left = 1;
        int right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < S; i++) {
                count += L[i] / mid;
            }

            if (count >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(sum - (1L * C * right));

        br.close();
    }
}