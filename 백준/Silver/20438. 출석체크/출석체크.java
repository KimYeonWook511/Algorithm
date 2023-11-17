import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean sleep[] = new boolean[N + 3];
        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(st.nextToken())] = true;
        }

        int sum[] = new int[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!sleep[num]) {
                int tempNum = num;

                while (tempNum <= N + 2) {
                    if (!sleep[tempNum]) sum[tempNum] = 1;

                    tempNum += num;
                }
            }
        }

        for (int i = 3; i <= N + 2; i++) {
            sum[i] += sum[i - 1];
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            sb.append((E - S + 1) - (sum[E] - sum[S - 1])).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}