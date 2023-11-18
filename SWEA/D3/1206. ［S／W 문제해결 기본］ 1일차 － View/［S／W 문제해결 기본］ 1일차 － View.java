import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[] = new int[N + 4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i + 2] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int i = 2; i < N + 2; i++) {
                int h = arr[i];

                int left = Math.max(arr[i - 2], arr[i - 1]);
                int right = Math.max(arr[i + 1], arr[i + 2]);

                int max = Math.max(left, right);

                cnt += Math.max(h - max, 0);
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}