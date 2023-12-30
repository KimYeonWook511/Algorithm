import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        N -= K * (K + 1) / 2;

        if (N < 0) System.out.println(-1);
        else if (N % K == 0) System.out.println(K - 1);
        else System.out.println(K);

        br.close();
    }
}