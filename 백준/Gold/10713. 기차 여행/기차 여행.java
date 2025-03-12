import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int P[] = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (pre < cur) {
                P[pre]++;
                P[cur]--;

            } else {
                P[cur]++;
                P[pre]--;
            }

            pre = cur;
        }

        long result = 0;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());
            long C = Integer.parseInt(st.nextToken());

            result += Math.min(A * P[i], B * P[i] + C);

            P[i + 1] += P[i];
        }

        System.out.println(result);

        br.close();
    }
}