import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[3][n];

        for (int r = 0; r < 3; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int temp = Math.min(arr[0][0], Math.min(arr[1][0], arr[2][0]));
        boolean flag = false;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[0][i], Math.min(arr[1][i], arr[2][i]));
            int max = Math.max(arr[0][i], Math.max(arr[1][i], arr[2][i]));

            if (temp < min) temp = min;
            else temp++;

            if (temp > max) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? "NO" : "YES");

        br.close();
    }
}