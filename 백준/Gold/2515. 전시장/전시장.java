import java.io.*;
import java.util.*;

public class Main {
    static class Picture {
        int H, C;

        Picture (int H, int C) {
            this.H = H;
            this.C = C;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        Picture pictures[] = new Picture[N + 1];
        pictures[0] = new Picture(0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pictures[i] = new Picture(H, C);
        }

        Arrays.sort(pictures, new Comparator<Picture>() {
            @Override
            public int compare(Picture o1, Picture o2) {
                return Integer.compare(o1.H, o2.H);
            }
        });

        int dp[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Picture cur = pictures[i];

            int left = 1;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;

                if (cur.H - pictures[mid].H >= S) left = mid + 1;
                else right = mid - 1;
            }

            dp[i] = Math.max(dp[i - 1], dp[right] + cur.C);
        }

        System.out.println(dp[N]);

        br.close();
    }
}