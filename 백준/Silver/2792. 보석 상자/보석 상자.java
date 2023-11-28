import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 1_000_000_000;

        while (left < right) {
            int mid = (left + right) / 2;

            int cnt = M;

            for (int i = 0; i < M; i++) {
                cnt += (arr[i] - 1) / mid;
            }

            if (cnt <= N) right = mid;
            else left = mid + 1;
        }
 
        System.out.println(right);

        br.close();
    }
}