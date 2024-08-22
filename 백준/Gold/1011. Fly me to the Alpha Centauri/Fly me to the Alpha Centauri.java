import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int sqrt = (int)Math.sqrt(dist);

            sb.append(dist == sqrt * sqrt ? (sqrt << 1) - 1 : (dist > sqrt * sqrt + sqrt ? (sqrt << 1) + 1 : sqrt << 1)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}