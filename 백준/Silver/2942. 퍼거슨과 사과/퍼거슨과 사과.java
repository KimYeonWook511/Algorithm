import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int num = func(R, G);

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) sb.append(i).append(" ").append(R / i).append(" ").append(G / i).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int func(int a, int b) {
        return b == 0 ? a : func(b, a % b);
    }
}