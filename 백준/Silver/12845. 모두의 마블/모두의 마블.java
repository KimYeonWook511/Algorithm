import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());

            sum += num;
            max = Math.max(max, num);
        }

        System.out.println(max * (n - 2) + sum);

        br.close();
    }
}