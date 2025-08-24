import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long result = 0;
        if (X != Y) {
            long i = 1;

            while (true) {
                long val = i * i + i;

                if (val >= Y - X) {
                    result = i * 2 + (val - i < Y - X ? 0 : -1);
                    break;
                }

                i++;
            }
        }

        System.out.println(result);

        br.close();
    }
}