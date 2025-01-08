import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long val = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean flag = false;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= val) {
                flag = true;
                break;
            }

            val += arr[i];
        }

        System.out.println(flag ? "No" : "Yes");

        br.close();
    }
}