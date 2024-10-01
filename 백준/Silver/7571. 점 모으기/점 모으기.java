import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // N
        int M = Integer.parseInt(st.nextToken());

        int x[] = new int[M];
        int y[] = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int xMid = x[M >> 1];
        int yMid = y[M >> 1];

        int result = 0;
        for (int i = 0; i < M; i++) {
            result += Math.abs(xMid - x[i]);
            result += Math.abs(yMid - y[i]);
        }

        System.out.println(result);

        br.close();
    }
}