import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int answer = -1;
        int left = 0; // M>=1 이라 5로 해도 될듯
        int right = 5 * M;
        while (left <= right) {
            int mid = (left + right) / 2;

            int N = mid;
            int count = 0;
            while (N >= 5) {
                N /= 5;
                count += N;
            }

            if (count > M) {
                right = mid - 1;
            } else if (count < M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
