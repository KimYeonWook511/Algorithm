import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println(sum - ((N * (N - 1)) >> 1));

        br.close();
    }
}