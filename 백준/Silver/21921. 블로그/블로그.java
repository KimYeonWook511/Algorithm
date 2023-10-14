import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n + 1];
        int sum = 0;
        int max = 0;
        int day = 0;

        for (int i = 1; i < x; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        for (int i = x; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            sum -= arr[i - x];

            if (sum > max) {
                max = sum;
                day = 1;

            } else if (sum == max) {
                day++;
            }
        }

        if (max == 0) sb.append("SAD");
        else sb.append(max).append("\n").append(day);

        System.out.println(sb.toString());

        br.close();
    }
}