import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            long sum = 0;
            long max = 0;
            int cnt = 0;
            
            for (int i = N - 1; i >= 0; i--) {
                int val = arr[i];

                if (val > max) {
                    result += max * cnt - sum;

                    sum = 0;
                    cnt = 0;
                    max = val;

                } else {
                    sum += val;
                    cnt++;
                }
            }
            
            result += max * cnt - sum;

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}