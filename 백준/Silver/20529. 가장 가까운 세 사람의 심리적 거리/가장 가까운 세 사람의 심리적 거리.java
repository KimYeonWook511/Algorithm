import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N = 0;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if (N > 32) {
                sb.append("0\n");
                continue;
            }

            String arr[] = new String[N];

            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int k = i + 1; k < N; k++) {
                    for (int j = k + 1; j < N; j++) {
                        int sum = 0;

                        for (int idx = 0; idx < 4; idx++) {
                            if (arr[i].charAt(idx) != arr[k].charAt(idx)) sum++;
                            if (arr[i].charAt(idx) != arr[j].charAt(idx)) sum++;
                            if (arr[k].charAt(idx) != arr[j].charAt(idx)) sum++;
                        }

                        min = Math.min(min, sum);

                        if (min == 0) {
                            i = k = j = N;
                        }
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}