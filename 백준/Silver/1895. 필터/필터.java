import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[][] = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());
        int result = 0;

        for (int r = R - 3; r >= 0; r--) {
            for (int c = C - 3; c >= 0; c--) {
                int temp[] = new int[9];
                int idx = 0;

                for (int dr = 0; dr < 3; dr++) {
                    for (int dc = 0; dc < 3; dc++) {
                        temp[idx++] = arr[r + dr][c + dc];
                    }
                }

                Arrays.sort(temp);

                if (temp[4] >= T) result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}