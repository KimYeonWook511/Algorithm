import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int range = (int)(max - min + 1);

        boolean isSquare[] = new boolean[range];
        for (long i = 2; i <= 1_000_000; i++) {
            long square = i * i;
            long start = (min + square - 1) / square * square;
            for (long k = start; k <= max; k += square) {
                isSquare[(int)(k - min)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < range; i++) {
            if (!isSquare[i]) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}