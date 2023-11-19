import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 1];
        int cnt = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (sum >= 129 && sum <= 138) cnt++;
        }

        for (int i = L + 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum -= arr[i - L];
            sum += arr[i];

            if (sum >= 129 && sum <= 138) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}