import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.min(L, Math.min(W, H));

        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;

            if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N) right = mid;
            else left = mid;
        }

        System.out.println(left);

        br.close();
    }
}