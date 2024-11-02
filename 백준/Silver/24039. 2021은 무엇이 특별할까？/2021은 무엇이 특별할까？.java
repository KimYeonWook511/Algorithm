import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean isNotPrime[] = new boolean[10001];

        for (int i = 2; i * i <= 10000; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i * i; j <= 10000; j += i) {
                isNotPrime[j] = true;
            }
        }

        int arr[] = new int[10001];
        int idx = 0;

        for (int i = 2; i <= 10000; i++) {
            if (isNotPrime[i]) continue;

            arr[idx++] = i;
        }

        int val = 0;
        for (int i = 1; i < idx; i++) {
            val = arr[i - 1] * arr[i];

            if (val > N) {
                System.out.println(val);
                break;
            }
        }

        br.close();
    }
}