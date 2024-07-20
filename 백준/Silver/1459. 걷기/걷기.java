import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long val1 = (X + Y) * W;

        long val2 = 0;
        if ((X + Y) % 2 == 0) val2 = Math.max(X, Y) * S;
        else val2 = (Math.max(X, Y) - 1) * S + W;

        long val3 = (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W;

        System.out.println(Math.min(val1, Math.min(val2, val3)));

        br.close();
    }
}