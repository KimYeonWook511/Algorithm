import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int s = 0;
        int e = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            s = Math.max(s, Integer.parseInt(st.nextToken()));
            e = Math.min(e, Integer.parseInt(st.nextToken()));
        }

        System.out.println(e > s ? 0 : s - e);

        br.close();
    }
}