import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[9];
        int sum = 0;

        for (int run = 0; run < 9; run++) {
            int h = Integer.parseInt(br.readLine());

            arr[run] = h;
            sum += h;
        }

        Arrays.sort(arr);

        for (int i = 0; i < 8; i++) {
            for (int k = i + 1; k < 9; k++) {
                if (sum - arr[i] - arr[k] == 100) {
                    arr[i] = 0;
                    arr[k] = 0;
                    i = 8;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}