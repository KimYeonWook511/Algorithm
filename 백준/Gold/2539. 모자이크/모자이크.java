import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int maxR = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // r, c 중 최댓값

        int maxPaper = Integer.parseInt(br.readLine());
        
        int M = Integer.parseInt(br.readLine());
        int minR = 0;
        int col[] = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            minR = Math.max(minR, r);
            col[i] = c;
        }

        Arrays.sort(col);

        while (minR <= maxR) {
            int mid = (minR + maxR) >> 1;

            int cnt = 1;
            int temp = col[0];
            for (int i = 1; i < M; i++) {
                if (col[i] - temp >= mid) {
                    cnt++;
                    temp = col[i];
                }
            }

            if (cnt > maxPaper) minR = mid + 1;
            else maxR = mid - 1;
        }

        System.out.println(minR);

        br.close();
    }
}