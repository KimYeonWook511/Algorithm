import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int km[] = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            km[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long result = 0;
        long sum = 0;
        long min = 1_000_000_000;

        for (int i = 0; i < N - 1; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (val < min) {
                result += sum * min;
                sum = km[i];
                min = val;

            } else {
                sum += km[i];
            }
        }

        result += sum * min;
        System.out.println(result);

        br.close();
    }
}