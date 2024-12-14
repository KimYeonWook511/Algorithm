import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int a = 0;
        int b = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            a += num % 2;
            b += num >> 1;
        }

        System.out.println(a > b || sum % 3 > 0 ? "NO" : "YES");
        
        br.close();
    }
}