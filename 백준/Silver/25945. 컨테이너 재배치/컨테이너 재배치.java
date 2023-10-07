import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int arr[] = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            m += num;
            arr[i] = num;
        }

        m /= n;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < m) num1 += m - arr[i];
            else if (arr[i] > m + 1) num2 += arr[i] - m - 1;
        }

        System.out.println(Math.max(num1, num2));

        br.close();
    }
}