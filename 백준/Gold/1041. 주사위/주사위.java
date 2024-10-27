import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dice[] = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            Arrays.sort(dice);

            for (int i = 1; i < 5; i++) {
                dice[i] += dice[i - 1];
            }

            System.out.println(dice[4]);

        } else {
            long arr[] = new long[3];
            arr[0] = 4L;
            arr[1] = 8L * (N - 2) + 4;
            arr[2] = 5L * (N - 2) * (N - 2) + 4L * (N - 2);

            int min[] = {Math.min(dice[0], dice[5]), Math.min(dice[1], dice[4]), Math.min(dice[2], dice[3])};
            Arrays.sort(min);

            long result = 4L * (min[0] + min[1] + min[2]);
            result += (8L * (N - 2) + 4) * (min[0] + min[1]);
            result += (5L * (N - 2) * (N - 2) + 4L * (N - 2)) * min[0];

            System.out.println(result);
        }

        br.close();
    }
}