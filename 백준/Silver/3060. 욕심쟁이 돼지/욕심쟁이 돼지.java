import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int day = 1;
            int temp = 0;

            for (int i = 0; i < 6; i++) {
                temp += Integer.parseInt(st.nextToken());
            }

            while (true) {
                if (temp > N) break;

                day++;
                temp *= 4;
            }

            sb.append(day).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}