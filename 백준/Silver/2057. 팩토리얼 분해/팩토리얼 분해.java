import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        
        boolean result = false;
        
        if (N != 0) {
            long[] arr = new long[21];
            arr[0] = 1;

            for (int i = 1; i <= 20; i++) {
                arr[i] = arr[i - 1] * i;
            }

            for (int i = 20; i >= 0; i--) {
                if (N < arr[i]) continue;

                N -= arr[i];
            }

            result = N == 0 ? true : false;
        }

        System.out.println(result ? "YES" : "NO");

        br.close();
    }
}