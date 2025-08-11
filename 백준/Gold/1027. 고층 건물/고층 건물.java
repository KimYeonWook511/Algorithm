import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt[] = new int[N];
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            long denominator = 1; // 기울기 분모
            long numerator = arr[i + 1] - arr[i]; // 기울기 분자
            cnt[i]++;
            cnt[i + 1]++;
            
            for (int k = i + 2; k < N; k++) {
                long nextDenominator = k - i;
                long nextNumerator = arr[k] - arr[i];
                long lcm = denominator * nextDenominator / gcd(denominator, nextDenominator);

                long pre = numerator * lcm / denominator; // MAX: 1_000_000_000 * 50
                long next = nextNumerator * lcm / nextDenominator;

                if (next > pre) {
                    cnt[i]++;
                    cnt[k]++;
                    denominator = k - i;
                    numerator = arr[k] - arr[i];
                }
            }

            result = Math.max(result, cnt[i]);
        }

        System.out.println(Math.max(result, cnt[N - 1]));

        br.close();
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}