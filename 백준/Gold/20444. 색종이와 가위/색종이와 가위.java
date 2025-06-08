import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        boolean flag = false;
        long left = 0;
        long right = n >> 1;
        while (left <= right) {
            long r = (left + right) >> 1;
            long c = n - r;
            long cal = (r + 1) * (c + 1);

            if(cal == k) {
                flag = true;
                break;
            }
            
            if (cal < k) left = r + 1;
            else right = r - 1;
        }

        System.out.println(flag ? "YES" : "NO");

        br.close();
    }
}