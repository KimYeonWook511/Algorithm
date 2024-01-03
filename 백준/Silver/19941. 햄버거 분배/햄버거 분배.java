import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean h[] = new boolean[N];
        boolean p[] = new boolean[N];
        String str = br.readLine();
       
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);

            if (c == 'H') h[i] = true;
            else p[i] = true;
        }

        int cnt = 0;
       
        for (int i = 0; i < N; i++) {
            if (p[i]) {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
               
                for (int s = start; s <= end; s++) {
                    if (h[s]) {
                        h[s] = false;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
       
        br.close();
    }
}