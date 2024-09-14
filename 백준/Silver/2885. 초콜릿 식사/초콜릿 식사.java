import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int size = 1;
        int result = 0;

        while (size < K) {
            size <<= 1;
        }
        sb.append(size).append(" ");

        while (K > 0) {
            if (K >= size) {
                K -= size;
                continue;
            }

            size >>= 1;
            result++;
        }
        sb.append(result);

        System.out.println(sb);

        br.close();
    }
}