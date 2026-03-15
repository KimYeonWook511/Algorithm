import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long v[] = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }

        long answer = v[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            answer = ((answer + v[i] - 1) / v[i]) * v[i];
        }

        System.out.println(answer);

        br.close();
    }
}