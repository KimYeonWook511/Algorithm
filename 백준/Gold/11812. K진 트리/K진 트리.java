import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (K == 1) {
            // 편향된 트리 -> 깊이가 N이 됨
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                sb.append(Math.abs(x - y)).append("\n");
            }
        } else {
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                int answer = 0;

                // depth 구하기
                int xDepth = calDepth(x, K);
                int yDepth = calDepth(y, K);

                // depth 맞추기
                while (xDepth > yDepth) {
                    x = (x + (K - 2)) / K; // x의 부모
                    xDepth--;
                    answer++;
                }
                while (xDepth < yDepth) {
                    y = (y + (K - 2)) / K; // y의 부모
                    yDepth--;
                    answer++;
                }

                // 공통 조상 찾기
                while (x != y) {
                    x = (x + (K - 2)) / K; // x의 부모
                    y = (y + (K - 2)) / K; // y의 부모
                    answer += 2;
                }

                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

    static int calDepth(long num, long K) {
        int depth = 0;

        while (num != 1) {
            num = (num + (K - 2)) / K;
            depth++;
        }

        return depth;
    }
}