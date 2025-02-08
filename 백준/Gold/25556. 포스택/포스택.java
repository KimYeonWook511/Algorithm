import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean result = true;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for (int k = 0; k < 4; k++) {
                if (arr[k] >= num) continue;

                arr[k] = num;
                flag = true;
                break;
            }

            if (!flag) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "YES" : "NO");

        br.close();
    }
}