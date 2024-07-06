import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i - 1] > arr[i]) {
                cnt = 0;
            }

            cnt++;
            result += cnt;
        }

        System.out.println(result);

        br.close();
    }
}