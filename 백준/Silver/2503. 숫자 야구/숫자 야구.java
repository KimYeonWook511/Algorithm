import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][3];

        for (int run = 0; run < N; run++) {
            st = new StringTokenizer(br.readLine());

            arr[run][0] = Integer.parseInt(st.nextToken());
            arr[run][1] = Integer.parseInt(st.nextToken());
            arr[run][2] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 123; i <= 987; i++) {
            int i1 = i / 100;
            int i2 = i % 100 / 10;
            int i3 = i % 100 % 10;

            if (i1 == i2 || i1 == i3 || i2 == i3 || i1 == 0 || i2 == 0 || i3 == 0) continue;

            int cnt = 0;

            for (int r = 0; r < N; r++) {
                int s = 0;
                int b = 0;
                int num = arr[r][0];
                int r1 = num / 100;
                int r2 = num % 100 / 10;
                int r3 = num % 100 % 10;

                if (i1 == r1) s++;
                if (i2 == r2) s++;
                if (i3 == r3) s++;

                if (i1 == r2 || i1 == r3) b++;
                if (i2 == r1 || i2 == r3) b++;
                if (i3 == r1 || i3 == r2) b++;

                if (s == arr[r][1] && b == arr[r][2]) cnt++;
                else break;
            }
            
            if (cnt == N) result++;
        }

        System.out.println(result);

        br.close();
    }
}