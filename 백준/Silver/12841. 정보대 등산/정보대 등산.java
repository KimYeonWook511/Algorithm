import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cross[] = new int[n];
        for (int i = 0; i < n; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }
    
        st = new StringTokenizer(br.readLine());

        long left[] = new long[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        long right[] = new long[n];
        for (int i = 1; i < n; i++) {
            right[i] = right[i - 1] + Integer.parseInt(st.nextToken());
        }

        int point = 0;
        long min = 10_000_000_000l;

        for (int i = 0; i < n; i++) {
            long d = right[n - 1] - right[i] + left[i] + cross[i];

            if (d < min) {
                min = d;
                point = i;
            }
        }

        System.out.println((point + 1) + " " + min);

        br.close();
    }
}