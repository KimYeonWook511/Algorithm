import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long left = 0;
        long right = (long)Math.pow(10, String.valueOf(n).length() / 2 + 1);

        while (left < right) {
            long mid = (left + right) / 2;

            double val = Math.pow(mid, 2);

            if (val >= n) right = mid;
            else left = mid + 1;
        }

        System.out.println(right);

        br.close();
    }
}