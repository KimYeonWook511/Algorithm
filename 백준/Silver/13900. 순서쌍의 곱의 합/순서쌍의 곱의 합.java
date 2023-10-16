import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
            sum -= arr[i];
            result += arr[i] * sum;
        }

        System.out.println(result);

        br.close();
    }
}