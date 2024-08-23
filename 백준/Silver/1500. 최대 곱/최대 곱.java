import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long d = S / K;
        long m = S % K;

		System.out.println((long)(Math.pow(d, K - m) * Math.pow(d + 1, m)));

        br.close();
    }
}