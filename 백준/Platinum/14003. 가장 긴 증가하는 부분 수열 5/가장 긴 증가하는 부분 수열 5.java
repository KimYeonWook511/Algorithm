import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];
        int arr[] = new int[N];
        int len = 0;
        int dpIdx[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = len - 1;

            while (left <= right) {
                int mid = (left + right) >> 1;

                if (arr[mid] >= input[i]) right = mid - 1;
                else left = mid + 1;
            }

            arr[left] = input[i];
            dpIdx[i] = left;

            if (left == len) len++;
        }

        sb.append(len).append("\n");

        int result[] = new int[len];
        len--;
        for (int i = N - 1; i >= 0; i--) {
            if (dpIdx[i] != len) continue;

            result[len] = input[i];

            if (--len < 0) break;
        }
        
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
        
        br.close();
    }
}