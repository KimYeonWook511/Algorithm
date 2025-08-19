import java.io.*;
import java.util.*;

public class Main {
    static class Star {
        int r, c;

        Star (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // N
        st.nextToken(); // M
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Star stars[] = new Star[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i] = new Star(y, x);
        }

        int result = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                // 기준
                int r = stars[i].r;
                int c = stars[j].c;

                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k].r < r || stars[k].r > r + L) continue;
                    if (stars[k].c < c || stars[k].c > c + L) continue;
                
                    cnt++;
                }

                result = Math.max(result, cnt);
            }
        }

        System.out.println(K - result);

        br.close();
    }
}