import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sqrt = (int)Math.sqrt(N);

        int result = N - 1;

        if (N % 2 == 0) {
            result = N >> 1;

        } else {
            for (int i = 3; i <= sqrt; i+=2) {
                if (N % i != 0) continue;

                result = N - N / i;
                break;
            }    
        }

        System.out.println(result);

        br.close();
    }
}