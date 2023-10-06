import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());

        for (int i = 2; i < n; i++) {
            int w = Integer.parseInt(st.nextToken());

            if (sum > 0) sum -= w;
            else sum += w;
        }

        sum = Math.abs(sum);

        int arr[] = {1, 2, 5, 10, 20, 50, 100};
        int result = 0;

        for (int i = 6; i >= 0; i--) {
            result += sum / arr[i];
            sum %= arr[i];
        }

        System.out.println(result);

        br.close();
    }
}