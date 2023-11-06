import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        long arr[] = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }
        
        long result = 0;
        
        for (int i = 1; i < N; i++) {
            sum -= arr[i];
            result = (result + sum % MOD * arr[i]) % MOD;
        }

        System.out.println(result);

        br.close();
    }
}