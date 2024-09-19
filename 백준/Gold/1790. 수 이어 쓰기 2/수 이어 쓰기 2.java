import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int val = 1;
        int sum = 0;
        int num = 0;
        int idx = 0;

        for (int i = 1; i <= 8; i++) {
            int cnt = val * 9;

            if (sum + cnt * i < k) {
                sum += cnt * i;
                val *= 10;
                continue;
            }

            idx = i;
            num = k - sum - 1;
            break;
        }

        if (idx == 0) System.out.println(k - sum <= 9 ? (k - sum == 0 ? 1 : 0) : -1);
        else System.out.println(num / idx + val > N ? -1 : Integer.toString(num / idx + val).charAt(num % idx) - '0');
        
        br.close();
    }
}