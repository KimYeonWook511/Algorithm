import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());    

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int result = 0;

            boolean arr[][] = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                int cnt = 0;

                for (int c = 0; c < N; c++) {
                    arr[r][c] = st.nextToken().equals("1") ? true : false;

                    if (arr[r][c]) {
                        cnt++;

                    } else {
                        if (cnt == K) result++;

                        cnt = 0;
                    }
                }

                if (cnt == K) result++;
            }

            for (int c = 0; c < N; c++) {
                int cnt = 0;

                for (int r = 0; r < N; r++) {
                    if (arr[r][c]) {
                        cnt++;

                    } else {
                        if (cnt == K) result++;

                        cnt = 0;
                    }
                }

                if (cnt == K) result++;
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}