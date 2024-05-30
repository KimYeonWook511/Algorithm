import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int run = 0; run < M; run++) {
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;
            int mid = 0;

            while (left <= right) {
                mid = (left + right) / 2;

                if (arr[mid] < num) left = mid + 1;
                else right = mid - 1;
            }

            sb.append(left < N && arr[left] == num ? left : "-1").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}