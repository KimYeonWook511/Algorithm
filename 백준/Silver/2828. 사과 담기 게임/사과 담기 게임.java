import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken()); // N
        int M = Integer.parseInt(st.nextToken());
        
        int left = 1;
        int right = M;

        int J = Integer.parseInt(br.readLine());

        int result = 0;

        for (int run = 0; run < J; run++) {
            int num = Integer.parseInt(br.readLine());

            if (num < left) {
                num = left - num;

                result += num;
                left -= num;
                right -= num;

            } else if (num > right) {
                num = num - right;

                result += num;
                left += num;
                right += num;
            }
        }

        System.out.println(result);

        br.close();
    }
}