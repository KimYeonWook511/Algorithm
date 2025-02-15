import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int l = 1;
        int r = (int)Math.min(Math.pow(10L, 9), (long)N * N);

        while (l < r) {
            int mid = (l + r) >> 1;

            int temp = 0;
            int sum = 0;
            for (int i = N; i >= 1; i--) {
                int val = Math.min(N, mid / i);

                sum += (val - temp) * i;

                if (val == N) break;
                if (sum > k) break;

                temp = val;
            }

            if (sum < k) l = mid + 1;
            else r = mid;
        }

        System.out.println(l);

        br.close();
    }
}