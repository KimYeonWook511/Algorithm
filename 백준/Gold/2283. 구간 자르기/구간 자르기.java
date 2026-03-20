import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sum[] = new int[1_000_002];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sum[left] += 1;
            sum[right] -= 1;
        }

        int cur = 0;
        int A = 0;
        int B = 0;
        while (B <= 1_000_000) {
            cur += sum[B];

            while (cur > K && A <= B) {
                cur -= sum[A];
                A++;
            }

            if (cur == K) {
                break;
            }

            sum[B + 1] += sum[B];
            B++;
        }

        if (B > 1_000_000) {
            System.out.println("0 0");
        } else {
            System.out.println(A + " " + (B + 1));
        }

        br.close();
    }
}