import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long arr[] = new long[n];
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (sum - arr[i]) * arr[i];
            sum -= arr[i];
        }

        System.out.println(result);

        br.close();
    }
}