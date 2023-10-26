import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int cnt = 1;
            int temp = arr[1];

            for (int i = 2; i <= N; i++) {
                if (arr[i] < temp) {
                    cnt++;
                    temp = arr[i];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}