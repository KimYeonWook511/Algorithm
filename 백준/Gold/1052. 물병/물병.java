import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;
        while (true) {
            int val = N + result;
            int cnt = 0;
            
            while (val > 0) {
                if (val % 2 != 0) cnt++;

                val >>= 1;
            }
            
            if (cnt <= K) break;
            
            result++;
        }

        System.out.println(result);

        br.close();
    }
}