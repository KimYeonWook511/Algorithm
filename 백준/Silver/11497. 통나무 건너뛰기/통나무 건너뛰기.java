import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int N = Integer.parseInt(br.readLine());

            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int max = Math.max(arr[N - 1] - arr[N - 2], arr[1] - arr[0]);

            int tempL = arr[N - 1];

            for (int i = N - 3; i >= 0; i -= 2) {
                max = Math.max(max, tempL - arr[i]);

                tempL = arr[i];
            }

            tempL = arr[N - 2];

            for (int i = N - 4; i >= 0; i -= 2) {
                max = Math.max(max, tempL - arr[i]);

                tempL = arr[i];
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}